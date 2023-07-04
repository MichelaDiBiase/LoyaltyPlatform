package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlanCoalition;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("coalitionRegistration")
@NoArgsConstructor
public class RegistrationLoyaltyPlanCoalition extends RegistrationLoyaltyPlan {
    public RegistrationLoyaltyPlanCoalition(Integer idCustomer, LoyaltyPlanCoalition loyaltyPlanCoalition) {
        super(idCustomer, loyaltyPlanCoalition);
    }
}
