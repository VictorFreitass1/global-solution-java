package pamv.com.controller;

import pamv.com.dominio.Medicos;
import pamv.com.service.MedicosService;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/medicos")
public class MedicosController {
    private final MedicosService medicosService;
    
    public MedicosController() {
        this.medicosService = new MedicosService();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarMedico(Medicos medico) {
    	try {
	        medicosService.cadastrarMedico(medico);
	        return Response.status(Response.Status.CREATED).entity("Medico cadastrado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar Medico").build();
        }
    }

    @POST
    @Path("/loginMedico")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response realizarLoginMedico(Medicos medico) {
        try {
            Medicos loggedInMedico = medicosService.realizarLogin(medico.getEmail(), medico.getSenha());
            if (loggedInMedico != null) {
                return Response.status(Response.Status.OK).entity(loggedInMedico).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarMedico(@PathParam("id") int id, Medicos medico) {
    	try {
	        medico.setIdMedico(id);
	        medicosService.atualizarMedico(medico);
	        return Response.status(Response.Status.OK).entity("Medico atualizada com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar medico").build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    public Response deletarMedico(@PathParam("id") int id) {
    	try {
	        medicosService.deletarMedico(id);
	        return Response.status(Response.Status.OK).entity("Medico deletado com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar medico").build();
        }
    }
    
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarConsultas() {
	    try { 
	    	List<Medicos> medicos = medicosService.listarTodosMedicos();
	    	return Response.status(Response.Status.OK).entity(medicos).build();
	    } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar medicos").build();
        }
    }
}
