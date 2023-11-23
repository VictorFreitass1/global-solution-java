package pamv.com.controller;

import pamv.com.dominio.Consultas;
import pamv.com.service.ConsultasService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/consultas")
public class ConsultasController {
    private final ConsultasService consultasService;

    public ConsultasController() {
        this.consultasService = new ConsultasService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarConsulta(Consultas consulta) {
        try {
            consultasService.cadastrarConsulta(consulta);
            return Response.status(Response.Status.CREATED).entity("Consulta cadastrada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar consulta").build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarConsulta(Consultas consulta) {
        try {
            consultasService.atualizarConsulta(consulta);
            return Response.status(Response.Status.OK).entity("Consulta atualizada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar consulta").build();
        }
    }

    @DELETE
    @Path("/deletar/{idConsulta}")
    public Response deletarConsulta(@PathParam("idConsulta") int idConsulta) {
        try {
            consultasService.deletarConsulta(idConsulta);
            return Response.status(Response.Status.OK).entity("Consulta deletada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar consulta").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarConsultas() {
        try {
            List<Consultas> consultas = consultasService.listarConsultas();
            return Response.status(Response.Status.OK).entity(consultas).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar consultas").build();
        }
    }
}
