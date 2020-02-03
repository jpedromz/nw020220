package com.teste.fichapacientes.rest;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teste.fichapacientes.data.PlanoDeSaudeRepository;
import com.teste.fichapacientes.model.PlanoDeSaude;
import com.teste.fichapacientes.service.PlanoDeSaudeRegistration;

/**
 * JAX-RS para Plano de Saude
 * <p/>
 * This class produces a RESTful service to read/write the contents of the planos de saude table.
 */
@Path("/planos-de-saude")
@RequestScoped
public class PlanoDeSaudeResourceRESTService {

    @Inject
    private PlanoDeSaudeRepository repository;

    @Inject
    PlanoDeSaudeRegistration registration;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlanoDeSaude> listAllMembers() {
        return repository.findAllOrderedByName();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlanoDeSaude lookupPlanoDeSaudeById(@PathParam("id") long id) {
        PlanoDeSaude planoDeSaude = repository.findById(id);
        if (planoDeSaude == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return planoDeSaude;
    }

}
