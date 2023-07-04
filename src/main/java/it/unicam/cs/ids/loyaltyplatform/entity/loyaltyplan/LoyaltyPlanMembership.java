package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("membership")
public class LoyaltyPlanMembership extends LoyaltyPlan {

    public LoyaltyPlanMembership(Integer idAgency) {
        super(idAgency);
    }

    public LoyaltyPlanMembership() {

    }

}