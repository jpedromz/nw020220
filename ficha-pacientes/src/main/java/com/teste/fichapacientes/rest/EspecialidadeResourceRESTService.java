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

import com.teste.fichapacientes.data.EspecialidadeRepository;
import com.teste.fichapacientes.model.Especialidade;
import com.teste.fichapacientes.service.EspecialidadeRegistration;

/**
 * JAX-RS para Especialidades
 * <p/>
 * This class produces a RESTful service to read/write the contents of the especialidades table.
 */
@Path("/especialidades")
@RequestScoped
public class EspecialidadeResourceRESTService {

    @Inject
    private EspecialidadeRepository repository;

    @Inject
    EspecialidadeRegistration registration;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Especialidade> listAllMembers() {
        return repository.findAllOrderedByName();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Especialidade lookupEspecialidadeById(@PathParam("id") long id) {
        Especialidade Especialidade = repository.findById(id);
        if (Especialidade == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Especialidade;
    }


}
