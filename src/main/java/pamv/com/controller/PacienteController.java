package pamv.com.controller;

import pamv.com.dominio.Paciente;
import pamv.com.service.PacienteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;
    
    public PacienteController () {
    	this.pacienteService = new PacienteService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarPaciente(Paciente paciente) {
        try {
            pacienteService.cadastrarPaciente(paciente);
            return Response.status(Response.Status.CREATED).entity("Paciente cadastrado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar paciente").build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarPaciente(Paciente paciente) {
        try {
            pacienteService.atualizarPaciente(paciente);
            return Response.status(Response.Status.OK).entity("Paciente atualizado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar paciente").build();
        }
    }

    @DELETE
    @Path("/deletar/{idPaciente}")
    public Response deletarPaciente(@PathParam("idPaciente") int idPaciente) {
        try {
            pacienteService.deletarPaciente(idPaciente);
            return Response.status(Response.Status.OK).entity("Paciente deletado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar paciente").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosPacientes() {
        try {
            List<Paciente> pacientes = pacienteService.listarTodosPacientes();
            return Response.status(Response.Status.OK).entity(pacientes).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar pacientes").build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response realizarLogin(Paciente paciente) {
        try {
            Paciente loggedInPaciente = pacienteService.realizarLogin(paciente.getEmail(), paciente.getSenha());
            if (loggedInPaciente != null) {
                return Response.status(Response.Status.OK).entity(loggedInPaciente).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
