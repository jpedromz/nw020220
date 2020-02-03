package com.teste.fichapacientes.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.teste.fichapacientes.model.Especialidade;

import java.util.logging.Logger;

@Stateless
public class EspecialidadeRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Especialidade> especialidadeEventSrc;

    public void register(Especialidade especialidade) throws Exception {
        log.info("Registering " + especialidade.getNome());
        em.persist(especialidade);
        especialidadeEventSrc.fire(especialidade);
    }
}
