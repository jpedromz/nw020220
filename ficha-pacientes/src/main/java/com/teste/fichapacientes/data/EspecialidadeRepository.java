package com.teste.fichapacientes.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.teste.fichapacientes.model.Especialidade;

import java.util.List;

@ApplicationScoped
public class EspecialidadeRepository {

    @Inject
    private EntityManager em;

    public Especialidade findById(Long id) {
        return em.find(Especialidade.class, id);
    }

    public Especialidade findByNome(String nome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Especialidade> criteria = cb.createQuery(Especialidade.class);
        Root<Especialidade> especialidade = criteria.from(Especialidade.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(especialidade).where(cb.equal(especialidade.get("nome"), nome));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Especialidade> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Especialidade> criteria = cb.createQuery(Especialidade.class);
        Root<Especialidade> especialidade = criteria.from(Especialidade.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(especialidade).orderBy(cb.asc(especialidade.get("nome")));
        return em.createQuery(criteria).getResultList();
    }
}
