package pamv.com.controller;

import pamv.com.dominio.PacienteProblema;
import pamv.com.service.PacienteProblemaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pacienteProblema")
public class PacienteProblemaController {
    private final PacienteProblemaService pacienteProblemaService;

    public PacienteProblemaController() {
        this.pacienteProblemaService = new PacienteProblemaService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarPacienteProblema(PacienteProblema pacienteProblema) {
    	try {
	        pacienteProblemaService.cadastrarPacienteProblema(pacienteProblema);
	        return Response.status(Response.Status.CREATED).entity("Paciente problema cadastrado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar paciente problema").build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarPacienteProblema(PacienteProblema pacienteProblema) {
    	try { 
	        pacienteProblemaService.atualizarPacienteProblema(pacienteProblema);
	        return Response.status(Response.Status.OK).entity("Paciente problema atualizado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar paciente problema").build();
        }
    }

    @DELETE
    @Path("/deletar/{idPaciente}/{idProblema}")
    public Response deletarPacienteProblema(@PathParam("idPaciente") int idPaciente, @PathParam("idProblema") int idProblema) {
        try {
    	pacienteProblemaService.deletarPacienteProblema(idPaciente, idProblema);
        return Response.status(Response.Status.OK).entity("Paciente problema deletado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar paciente problema").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPacienteProblema() {
    	try {
	        List<PacienteProblema> listaPacienteProblema = pacienteProblemaService.listarPacienteProblema();
	        return Response.status(Response.Status.OK).entity(listaPacienteProblema).build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar pacientes problema").build();
        }
	}
}