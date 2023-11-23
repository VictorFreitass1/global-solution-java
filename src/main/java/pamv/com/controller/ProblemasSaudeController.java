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

import pamv.com.dominio.ProblemasSaude;
import pamv.com.service.ProblemasSaudeService;

@Path("/problemas-saude")
public class ProblemasSaudeController {
    private final ProblemasSaudeService problemasSaudeService; 
    
    public ProblemasSaudeController() {
    	this.problemasSaudeService = new ProblemasSaudeService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarProblemaSaude(ProblemasSaude problemaSaude) {
    	try {
	        problemasSaudeService.cadastrarProblemaSaude(problemaSaude);
	        return Response.status(Response.Status.CREATED).entity("Problemas saúde cadastrada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar problemas saúde").build();
        }
    }

    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarProblemaSaude(@PathParam("id") int idProblema, ProblemasSaude problemaSaude) {
        try {
	    	problemaSaude.setIdProblema(idProblema);
	        problemasSaudeService.atualizarProblemaSaude(problemaSaude);
	        return Response.status(Response.Status.OK).entity("Problemas saúde atualizada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar problemas saúde").build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    public Response deletarProblemaSaude(@PathParam("id") int idProblema) {
    	try {
	    	problemasSaudeService.deletarProblemaSaude(idProblema);
	        return Response.status(Response.Status.OK).entity("Problemas saúde deletada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar problemas saúde").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProblemasSaude() {
    	try {
	        List<ProblemasSaude> listaProblemasSaude = problemasSaudeService.listarProblemasSaude();
	        return Response.status(Response.Status.OK).entity(listaProblemasSaude).build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar problemas saúde").build();
        }
    }
}