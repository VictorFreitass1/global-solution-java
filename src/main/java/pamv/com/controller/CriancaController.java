package pamv.com.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pamv.com.dominio.Crianca;
import pamv.com.service.CriancaService;

@Path("/crianca")
public class CriancaController {
    private final CriancaService criancaService;

    public CriancaController() {
        this.criancaService = new CriancaService();
    }
    
    @POST
    @Path("/cadastrarCrianca")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarCrianca(Crianca crianca) {
    	try {
	        criancaService.cadastrarCrianca(crianca);
	        return Response.status(Response.Status.CREATED).entity("Criança cadastrada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar crian�a").build();
        }
    }
    
    @PUT
    @Path("/atualizarCrianca/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarCrianca(@PathParam("id") int idCrianca, Crianca crianca) {
    	try {
	        crianca.setIdCrianca(idCrianca);
	        criancaService.atualizarCrianca(crianca);
	        return Response.status(Response.Status.OK).entity("Crian�a atualizada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar crian�a").build();
        }
    }
    
    @DELETE
    @Path("/deletarCrianca/{id}")
    public Response deletarCrianca(@PathParam("id") int idCrianca) {
    	try { 
	        criancaService.deletarCrianca(idCrianca);
	        return Response.status(Response.Status.OK).entity("Criança deletada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar crian�a").build();
        }
    }


    @GET
    @Path("/listarCrianca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCrianca() {
    	try {
	        List<Crianca> listaCrianca = criancaService.listarCriancas();
	        return Response.status(Response.Status.OK).entity(listaCrianca).build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar crian�a").build();
        }
    }
}