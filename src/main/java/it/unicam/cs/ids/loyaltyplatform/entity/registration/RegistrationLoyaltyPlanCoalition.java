package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("coalition")
@NoArgsConstructor
public class RegistrationLoyaltyPlanCoalition extends RegistrationLoyaltyPlan {
    public RegistrationLoyaltyPlanCoalition(Integer idCustomer, Integer idLoyaltyPlan) {
        super(idCustomer, idLoyaltyPlan);
    }
}
