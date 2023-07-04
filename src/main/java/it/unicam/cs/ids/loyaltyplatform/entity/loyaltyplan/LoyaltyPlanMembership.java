package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("membership")
public class LoyaltyPlanMembership extends LoyaltyPlan{

    @JoinColumn(name = "idFidelityCard")
    @OneToOne(cascade = CascadeType.ALL)
    FidelityCard fidelityCard;

    public LoyaltyPlanMembership(Integer idAgency, Integer registrationCount, FidelityCard fidelityCard){
        super(idAgency,registrationCount);
        this.fidelityCard = fidelityCard;
    }

    public LoyaltyPlanMembership(Integer idAgency, Integer registrationCount){
        super(idAgency,registrationCount);
    }

    public LoyaltyPlanMembership() {

    }

    public FidelityCard getFidelityCard() {
        return fidelityCard;
    }

    public void setFidelityCard(FidelityCard fidelityCard) {
        this.fidelityCard = fidelityCard;
    }
}