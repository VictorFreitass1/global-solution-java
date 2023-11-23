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

import pamv.com.dominio.ContatoMedicos;
import pamv.com.service.ContatoMedicosService;

@Path("/contatosMedicos")
public class ContatoMedicosController {
    private final ContatoMedicosService contatoMedicosService;
    
    public ContatoMedicosController() {
        this.contatoMedicosService = new ContatoMedicosService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarContatoMedico(ContatoMedicos contatoMedicos) {
        try {    
        	contatoMedicosService.cadastrarContatoMedico(contatoMedicos);
            return Response.status(Response.Status.CREATED).entity("Contato cadastrado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar contato").build();
        }
    }

    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarContatoMedico(@PathParam("id") int idMedico, ContatoMedicos contatoMedicos) {
        try {
	    	contatoMedicos.setIdMedico(idMedico);
	        contatoMedicosService.atualizarContatoMedico(contatoMedicos);
	        return Response.status(Response.Status.OK).entity("Contato atualizado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar contato").build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    public Response deletarContatoMedico(@PathParam("id") int idMedico) {
    	try {
    		contatoMedicosService.deletarContatoMedico(idMedico);
    		return Response.status(Response.Status.OK).entity("Contato deletado com sucesso").build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar contato").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarContatosMedicos() {
    	try {
	        List<ContatoMedicos> listaContatosMedicos = contatoMedicosService.listarContatosMedicos();
	        return Response.status(Response.Status.OK).entity(listaContatosMedicos).build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar contatos").build();
        }
    }
}