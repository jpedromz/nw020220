package com.teste.fichapacientes.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.teste.fichapacientes.model.Paciente;

import java.util.List;

@ApplicationScoped
public class PacienteRepository {

    @Inject
    private EntityManager em;

    public Paciente findById(Long id) {
        return em.find(Paciente.class, id);
    }

    public Paciente findByNome(String nome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Paciente> criteria = cb.createQuery(Paciente.class);
        Root<Paciente> paciente = criteria.from(Paciente.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(paciente).where(cb.equal(paciente.get("nomePaciente"), nome));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Paciente> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Paciente> criteria = cb.createQuery(Paciente.class);
        Root<Paciente> paciente = criteria.from(Paciente.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(paciente).orderBy(cb.asc(paciente.get("nomePaciente")));
        return em.createQuery(criteria).getResultList();
    }
}
