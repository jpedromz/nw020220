package com.teste.fichapacientes.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.teste.fichapacientes.model.PlanoDeSaude;

import java.util.List;

@RequestScoped
public class PlanoDeSaudeListProducer {

    @Inject
    private PlanoDeSaudeRepository memberRepository;

    private List<PlanoDeSaude> planosDeSaude;

    @Produces
    @Named
    public List<PlanoDeSaude> getPlanosDeSaude() {
        return planosDeSaude;
    }

    public void onPlanosDeSaudeListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final PlanoDeSaude planoDeSaude) {
    	retrieveAllPlanosDeSaudeOrderedByName();
    }

    @PostConstruct
    public void retrieveAllPlanosDeSaudeOrderedByName() {
        planosDeSaude = memberRepository.findAllOrderedByName();
    }
}
