package pamv.com.controller;

import pamv.com.service.AlimentacaoService;
import pamv.com.dominio.Alimentacao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/alimentacao")
public class AlimentacaoController {
    private final AlimentacaoService alimentacaoService;

    public AlimentacaoController() {
        this.alimentacaoService = new AlimentacaoService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarAlimentos(Alimentacao alimentacao) {
	    try {
	    	alimentacaoService.cadastrarAlimentos(alimentacao);
	        return Response.status(Response.Status.CREATED).entity("Alimento cadastrado com sucesso").build();
	    } catch (RuntimeException e) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar alimento").build();
	    }
    }
    
    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarAlimento(Alimentacao alimentacao) {
    	try {
	        alimentacaoService.atualizarAlimento(alimentacao);
	        return Response.status(Response.Status.OK).entity("Alimento atualizado com sucesso").build();
    	}	catch (RuntimeException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar alimento").build();
    	}
    }

    @DELETE
    @Path("/deletar/{idAlimentacao}")
    public Response deletarAlimento(@PathParam("idAlimentacao") int idAlimentacao) {
        try {
        	alimentacaoService.deletarAlimento(idAlimentacao);
        	return Response.status(Response.Status.OK).entity("Alimento deletado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar alimento").build();
        }
    }

    @GET
    @Path("/listarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosAlimentos() {
    	try {
    		List<Alimentacao> alimentos = alimentacaoService.listarTodosAlimentos();
	        return Response.status(Response.Status.OK).entity(alimentos).build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar alimentos").build();
        }
    }
}    
