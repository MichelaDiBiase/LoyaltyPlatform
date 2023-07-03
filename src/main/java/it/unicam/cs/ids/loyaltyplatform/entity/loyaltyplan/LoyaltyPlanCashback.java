package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cashback")

public class LoyaltyPlanCashback extends LoyaltyPlan{
    private double percentage;

    public LoyaltyPlanCashback (Integer idAgency, Integer registrationCount,double percentage){
        super(idAgency,registrationCount);
        this.percentage=percentage;
    }

    public LoyaltyPlanCashback () {

    }

    @Override
    public boolean useAdvantage(Customer customer) {
        if (customer.getLoyaltyPlans().parallelStream().noneMatch(x-> x instanceof LoyaltyPlanCashback && x.getIdAgency().equals(this.getIdAgency()))){

            return true;
        }
        return false;
    }


    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
