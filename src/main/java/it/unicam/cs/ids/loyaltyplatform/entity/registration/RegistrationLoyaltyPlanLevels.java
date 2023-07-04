package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlanLevels;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("levelsRegistration")
@NoArgsConstructor
public class RegistrationLoyaltyPlanLevels extends RegistrationLoyaltyPlan {
    public RegistrationLoyaltyPlanLevels(Integer idCustomer, LoyaltyPlanLevels loyaltyPlanLevels) {
        super(idCustomer, loyaltyPlanLevels);
    }
}
