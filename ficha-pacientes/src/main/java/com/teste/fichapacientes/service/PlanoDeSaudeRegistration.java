package com.teste.fichapacientes.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.teste.fichapacientes.model.PlanoDeSaude;

import java.util.logging.Logger;

@Stateless
public class PlanoDeSaudeRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<PlanoDeSaude> planoDeSaudeEventSrc;

    public void register(PlanoDeSaude planoDeSaude) throws Exception {
        log.info("Registering " + planoDeSaude.getNome());
        em.persist(planoDeSaude);
        planoDeSaudeEventSrc.fire(planoDeSaude);
    }
}
