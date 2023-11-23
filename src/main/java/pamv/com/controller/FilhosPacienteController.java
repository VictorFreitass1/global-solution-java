package pamv.com.controller;

import pamv.com.service.FilhosPacienteService;
import pamv.com.dominio.FilhosPaciente;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.List;

@Path("/filhos-pacientes")
public class FilhosPacienteController {
    private final FilhosPacienteService filhosPacienteService;
    
    public FilhosPacienteController () {
    	this.filhosPacienteService = new FilhosPacienteService();
    }

    public FilhosPacienteController(Connection connection) {
        this.filhosPacienteService = new FilhosPacienteService(connection);
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarFilho(FilhosPaciente filho) {
        try {
            filhosPacienteService.cadastrarFilho(filho);
            return Response.status(Response.Status.CREATED).entity("Filho cadastrado com sucesso").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar filho").build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarFilho(FilhosPaciente filho) {
        try {
            filhosPacienteService.atualizarFilho(filho);
            return Response.status(Response.Status.OK).entity("Filho atualizado com sucesso").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar filho").build();
        }
    }

    @DELETE
    @Path("/deletar/{idPaciente}")
    public Response deletarFilho(@PathParam("idPaciente") int idPaciente) {
        try {
            filhosPacienteService.deletarFilho(idPaciente);
            return Response.status(Response.Status.OK).entity("Filho deletado com sucesso").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar filho").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarFilhos() {
        try {
            List<FilhosPaciente> filhos = filhosPacienteService.listarFilhos();
            return Response.status(Response.Status.OK).entity(filhos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar filhos").build();
        }
    }
}
