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

import pamv.com.dominio.Vacinas;
import pamv.com.service.VacinaService;


@Path("/vacina")
public class VacinaController {
    private final VacinaService vacinaService;

    public VacinaController() {
        this.vacinaService = new VacinaService();
    }
    
    @POST
    @Path("/cadastrarVacina")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarVacina(Vacinas vacina) {
    	try {
	        vacinaService.cadastrarVacina(vacina);
	        return Response.status(Response.Status.CREATED).entity("Vacina cadastrada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar vacina").build();
        }
    }
    
    @PUT
    @Path("/atualizarVacina/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarVacina(@PathParam("id") int idVacina, Vacinas vacina) {
    	try {
	        vacina.setIdVacina(idVacina);
	        vacinaService.atualizarVacina(vacina);
	        return Response.status(Response.Status.OK).entity("Vacina atualizada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar vacina").build();
        }
    }
    
    @DELETE
    @Path("/deletarVacina/{id}")
    public Response deletarVacina(@PathParam("id") int idVacina) {
    	try {
	        vacinaService.deletarVacina(idVacina);
	        return Response.status(Response.Status.OK).entity("Vacina deletada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar vacina").build();
        }
    }
    
    @GET
    @Path("/listarVacina")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarVacina() {
    	try {
	        List<Vacinas> listaVacinas = vacinaService.listarVacina();
	        return Response.status(Response.Status.OK).entity(listaVacinas).build();
    	} catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar vacinas").build();
        }    
    }
}