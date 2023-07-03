package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("points")

public class LoyaltyPlanPoints extends LoyaltyPlan{


    public LoyaltyPlanPoints (Integer idAgency, Integer registrationCount){
        super(idAgency,registrationCount);

    }

    public LoyaltyPlanPoints () {

    }

    @Override
    public boolean useAdvantage(Customer customer) {
        if (customer.getLoyaltyPlans().parallelStream().noneMatch(x -> x instanceof LoyaltyPlanPoints && x.getIdAgency().equals(this.getIdAgency()))) {

            return true;
        }
        return false;
    }
}
