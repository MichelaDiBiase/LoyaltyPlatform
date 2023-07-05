package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.FidelityCard;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("membership")
@NoArgsConstructor
public class RegistrationLoyaltyPlanMembership extends RegistrationLoyaltyPlan {

    @JoinColumn(name = "idFidelityCard")
    @OneToOne(cascade = CascadeType.ALL)
    private FidelityCard fidelityCard;

    public RegistrationLoyaltyPlanMembership(Integer idCustomer, Integer idLoyaltyPlan) {
        super(idCustomer, idLoyaltyPlan);
    }

    public FidelityCard getFidelityCard() {
        return fidelityCard;
    }

    public void setFidelityCard(FidelityCard fidelityCard) {
        this.fidelityCard = fidelityCard;
    }
}
