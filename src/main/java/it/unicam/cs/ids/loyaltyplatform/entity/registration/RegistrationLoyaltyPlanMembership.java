package it.unicam.cs.ids.loyaltyplatform.entity.registration;


import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlanMembership;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.FidelityCard;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("membershipRegistration")
@NoArgsConstructor
public class RegistrationLoyaltyPlanMembership extends RegistrationLoyaltyPlan {

    @JoinColumn(name = "idFidelityCard")
    @OneToOne(cascade = CascadeType.ALL)
    FidelityCard fidelityCard;
    public RegistrationLoyaltyPlanMembership(Integer idCustomer, LoyaltyPlanMembership loyaltyPlanMembership, FidelityCard fidelityCard) {
        super(idCustomer, loyaltyPlanMembership);
        this.fidelityCard = fidelityCard;
    }

    public FidelityCard getFidelityCard() {
        return fidelityCard;
    }

    public void setFidelityCard(FidelityCard fidelityCard) {
        this.fidelityCard = fidelityCard;
    }
}
