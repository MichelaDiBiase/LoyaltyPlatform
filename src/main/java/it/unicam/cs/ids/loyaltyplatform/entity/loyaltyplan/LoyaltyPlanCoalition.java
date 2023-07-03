package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("planCoalition")

public class LoyaltyPlanCoalition extends LoyaltyPlan{


    public LoyaltyPlanCoalition (Integer idAgency, Integer registrationCount){
        super(idAgency,registrationCount);

    }

    public LoyaltyPlanCoalition () {

    }

    @Override
    public boolean useAdvantage(Customer customer) {
        if (customer.getLoyaltyPlans().parallelStream().noneMatch(x-> x instanceof LoyaltyPlanCoalition && x.getIdAgency().equals(this.getIdAgency()))){

            return true;
        }
        return false;
    }
}
