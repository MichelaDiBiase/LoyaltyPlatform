package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("cashback")
@NoArgsConstructor
public class RegistrationLoyaltyPlanCashback extends RegistrationLoyaltyPlan {
    public RegistrationLoyaltyPlanCashback(Integer idCustomer, Integer idLoyaltyPlan) {
        super(idCustomer, idLoyaltyPlan);
    }
}
