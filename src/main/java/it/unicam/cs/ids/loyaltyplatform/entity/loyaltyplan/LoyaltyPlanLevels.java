package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("levels")
public class LoyaltyPlanLevels extends LoyaltyPlan {


    public LoyaltyPlanLevels(Integer idAgency) {
        super(idAgency);
    }

    public LoyaltyPlanLevels() {

    }
}