package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("planLevels")

public class LoyaltyPlanLevels extends LoyaltyPlan {

    public LoyaltyPlanLevels (Integer idAgency, Integer registrationCount){
        super(idAgency,registrationCount);

    }

    public LoyaltyPlanLevels () {

    }

    @Override
    public boolean useAdvantage(Customer customer) {
        if (customer.getLoyaltyPlans().parallelStream().noneMatch(x-> x instanceof LoyaltyPlanLevels && x.getIdAgency().equals(this.getIdAgency()))){

            return true;
        }
        return false;
    }
}
