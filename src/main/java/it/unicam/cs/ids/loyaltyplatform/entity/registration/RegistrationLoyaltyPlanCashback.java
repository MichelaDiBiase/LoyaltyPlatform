package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlanCashback;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("cashbackRegistration")
@NoArgsConstructor
public class RegistrationLoyaltyPlanCashback extends RegistrationLoyaltyPlan {
    public RegistrationLoyaltyPlanCashback(Integer idCustomer, LoyaltyPlanCashback loyaltyPlanCashback) {
        super(idCustomer, loyaltyPlanCashback);
    }
}
