package pamv.com.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pamv.com.dominio.VacinasAdministradas;
import pamv.com.service.VacinasAdministradasService;

import java.util.List;

@Path("/vacinas")
public class VacinasAdministradasController {
    private final VacinasAdministradasService vacinasService;
    
    public VacinasAdministradasController() {
    	this.vacinasService = new VacinasAdministradasService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarVacina(VacinasAdministradas vacina) {
        try {
            vacinasService.cadastrarVacina(vacina);
            return Response.status(Response.Status.CREATED).entity("Vacinas administradas cadastrada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar vacinas administradas").build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarVacina(VacinasAdministradas vacina) {
        try {
            vacinasService.atualizarVacina(vacina);
            return Response.status(Response.Status.OK).entity("Vacinas administradas atualizada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar vacinas administradas").build();
        }
    }

    @DELETE
    @Path("/deletar/{idVacina}")
    public Response deletarVacina(@PathParam("idVacina") int idVacina) {
        try {
            vacinasService.deletarVacina(idVacina);
            return Response.status(Response.Status.OK).entity("Vacinas administradas deletada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar vacinas administradas").build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarVacinas() {
        try {
            List<VacinasAdministradas> vacinas = vacinasService.listarVacinas();
            return Response.status(Response.Status.OK).entity(vacinas).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar vacinas administradas").build();
        }
    }
}