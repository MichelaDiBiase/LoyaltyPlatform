package it.unicam.cs.ids.loyaltyplatform.entity.registration;


import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlanMembership;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("membershipRegistration")
@NoArgsConstructor
public class RegistrationLoyaltyPlanMembership extends RegistrationLoyaltyPlan {
    public RegistrationLoyaltyPlanMembership(Integer idCustomer, LoyaltyPlanMembership loyaltyPlanMembership) {
        super(idCustomer, loyaltyPlanMembership);
    }
}
