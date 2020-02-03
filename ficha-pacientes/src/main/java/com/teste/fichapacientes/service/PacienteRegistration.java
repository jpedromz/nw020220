package com.teste.fichapacientes.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.teste.fichapacientes.model.Paciente;

import java.util.logging.Logger;

@Stateless
public class PacienteRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Paciente> pacienteEventSrc;

    public void register(Paciente paciente) throws Exception {
        log.info("Registering " + paciente.getNomePaciente());
        em.persist(paciente);
        pacienteEventSrc.fire(paciente);
    }
}
