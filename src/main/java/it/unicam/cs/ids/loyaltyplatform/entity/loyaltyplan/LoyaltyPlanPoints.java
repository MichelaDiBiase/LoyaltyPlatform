package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;


import jakarta.persistence.*;



@Entity
@DiscriminatorValue("points")
public class LoyaltyPlanPoints extends LoyaltyPlan {

    public LoyaltyPlanPoints (Integer idAgency){
        super(idAgency);
    }

    public LoyaltyPlanPoints () {

    }
}