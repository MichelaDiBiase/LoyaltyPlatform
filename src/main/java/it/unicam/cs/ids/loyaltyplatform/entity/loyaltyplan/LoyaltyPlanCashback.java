package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cashback")
public class LoyaltyPlanCashback extends LoyaltyPlan{
    private Double percentage;

    public LoyaltyPlanCashback (Integer idAgency, Integer registrationCount,Double percentage){
        super(idAgency);
        this.percentage=percentage;
    }

    public LoyaltyPlanCashback () {

    }

    public Double calculateCashback(Double amount) {
        return amount * percentage / 100;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}