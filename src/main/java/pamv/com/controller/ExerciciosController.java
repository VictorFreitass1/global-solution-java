package pamv.com.controller;

import pamv.com.dominio.Exercicios;
import pamv.com.service.ExerciciosService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/exercicios")
public class ExerciciosController {
    private final ExerciciosService exerciciosService;

    public ExerciciosController() {
        this.exerciciosService = new ExerciciosService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarExercicio(Exercicios exercicio) {
        try {
            exerciciosService.cadastrarExercicio(exercicio);
            return Response.status(Response.Status.CREATED).entity("Exerc�cio cadastrado com sucesso!").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar exerc�cio: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarExercicio(Exercicios exercicio) {
        try {
            exerciciosService.atualizarExercicio(exercicio);
            return Response.status(Response.Status.OK).entity("Exerc�cio atualizado com sucesso!").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar exerc�cio: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/deletar/{idExercicio}")
    public Response deletarExercicio(@PathParam("idExercicio") int idExercicio) {
        try {
            exerciciosService.deletarExercicio(idExercicio);
            return Response.status(Response.Status.OK).entity("Exerc�cio deletado com sucesso!").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar exerc�cio: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarExercicios() {
        try {
            List<Exercicios> exercicios = exerciciosService.listarExercicios();
            return Response.status(Response.Status.OK).entity(exercicios).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar exerc�cios: " + e.getMessage()).build();
        }
    }
}
