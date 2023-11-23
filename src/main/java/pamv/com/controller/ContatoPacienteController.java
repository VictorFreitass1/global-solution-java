package pamv.com.controller;

import pamv.com.dominio.ContatoPaciente;
import pamv.com.service.ContatoPacienteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contatoPaciente")
public class ContatoPacienteController {
    private final ContatoPacienteService contatoPacienteService;

    public ContatoPacienteController() {
        this.contatoPacienteService = new ContatoPacienteService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarContatoPaciente(ContatoPaciente contatoPaciente) {
    	try { 
        contatoPacienteService.cadastrarContatoPaciente(contatoPaciente);
        return Response.status(Response.Status.CREATED).entity("Contato cadastrado com sucesso").build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar contato").build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarContatoPaciente(ContatoPaciente contatoPaciente) {
    	try {
	        contatoPacienteService.atualizarContatoPaciente(contatoPaciente);
	        return Response.status(Response.Status.OK).entity("Contato atualizada com sucesso").build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar contato").build();
        }
    }

    @DELETE
    @Path("/deletar/{idPaciente}")
    public Response deletarContatoPaciente(@PathParam("idPaciente") int idPaciente) {
    	try {
	        contatoPacienteService.deletarContatoPaciente(idPaciente);
	        return Response.status(Response.Status.OK).entity("Contato deletada com sucesso").build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar contato").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosContatosPacientes() {
    	try {
	        List<ContatoPaciente> listaContatosPacientes = contatoPacienteService.listarTodosContatosPacientes();
	        return Response.status(Response.Status.OK).entity(listaContatosPacientes).build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar contato").build();
        }
    }
}
