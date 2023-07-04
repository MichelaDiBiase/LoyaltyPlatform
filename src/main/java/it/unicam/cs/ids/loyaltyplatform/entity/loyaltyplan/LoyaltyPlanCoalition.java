package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Agency;
import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("planCoalition")
public class LoyaltyPlanCoalition extends LoyaltyPlan{

    @JoinColumn(name = "idAgency")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Agency> agenciesCoalition;

    public LoyaltyPlanCoalition (Integer idAgency, Integer registrationCount, List<Agency> agenciesCoalition){
        super(idAgency,registrationCount);
        this.agenciesCoalition = agenciesCoalition;
    }

    public LoyaltyPlanCoalition (Integer idAgency, Integer registrationCount){
        super(idAgency,registrationCount);
    }

    public LoyaltyPlanCoalition () {

    }

    public void addAgencyToCoalition(Agency agency) {
        if(agenciesCoalition.parallelStream().anyMatch(x -> x.getId().equals(agency.getId()))) {
            throw new EntityExistsException("The id(" + agency.getId() + ") of the Agency is already in the coalition");
        }
        agenciesCoalition.add(agency);
    }

    public void removeAgencyToCoalition(Agency agency) {
        if(agenciesCoalition.parallelStream().noneMatch(x -> x.getId().equals(agency.getId()))) {
            throw new EntityExistsException("The id(" + agency.getId() + ") of the Agency is not in the coalition");
        }
        agenciesCoalition.remove(agency);
    }

    public List<Agency> getAgenciesCoalition() {
        return agenciesCoalition;
    }
}