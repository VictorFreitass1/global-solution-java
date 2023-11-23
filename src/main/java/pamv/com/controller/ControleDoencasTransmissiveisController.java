package pamv.com.controller;

import pamv.com.dominio.ControleDoencasTransmissiveis;
import pamv.com.service.ControleDoencasTransmissiveisService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/controleDoencasTransmissiveis")
public class ControleDoencasTransmissiveisController {
    private final ControleDoencasTransmissiveisService controleService;

    public ControleDoencasTransmissiveisController() {
        this.controleService = new ControleDoencasTransmissiveisService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarControleDoencasTransmissiveis(ControleDoencasTransmissiveis controle) {
        try {
            controleService.cadastrarControleDoencasTransmissiveis(controle);
            return Response.status(Response.Status.CREATED).entity("Controle de doen�as transmissiveis cadastrado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar controle de doen�as transmissiveis").build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarControleDoencasTransmissiveis(ControleDoencasTransmissiveis controle) {
        try {
            controleService.atualizarControleDoencasTransmissiveis(controle);
            return Response.status(Response.Status.OK).entity("Controle de doen�as transmissiveis atualizado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar controle de doen�as transmissiveis").build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    public Response deletarControleDoencasTransmissiveis(@PathParam("id") int idControle) {
        try {
            controleService.deletarControleDoencasTransmissiveis(idControle);
            return Response.status(Response.Status.OK).entity("Controle de doen�as transmissiveis deletado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar controle de doen�as transmissiveis").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarControleDoencasTransmissiveis() {
        try {
            List<ControleDoencasTransmissiveis> controles = controleService.listarControleDoencasTransmissiveis();
            return Response.status(Response.Status.OK).entity(controles).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar Controle de doen�as transmissiveis").build();
        }
    }
}
