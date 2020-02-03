package com.teste.fichapacientes.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.teste.fichapacientes.model.PlanoDeSaude;

import java.util.List;

@ApplicationScoped
public class PlanoDeSaudeRepository {

    @Inject
    private EntityManager em;

    public PlanoDeSaude findById(Long id) {
        return em.find(PlanoDeSaude.class, id);
    }

    public PlanoDeSaude findByNome(String nome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PlanoDeSaude> criteria = cb.createQuery(PlanoDeSaude.class);
        Root<PlanoDeSaude> planoDeSaude = criteria.from(PlanoDeSaude.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(planoDeSaude).where(cb.equal(planoDeSaude.get("nome"), nome));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<PlanoDeSaude> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PlanoDeSaude> criteria = cb.createQuery(PlanoDeSaude.class);
        Root<PlanoDeSaude> planoDeSaude = criteria.from(PlanoDeSaude.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(planoDeSaude).orderBy(cb.asc(planoDeSaude.get("nome")));
        return em.createQuery(criteria).getResultList();
    }
}
