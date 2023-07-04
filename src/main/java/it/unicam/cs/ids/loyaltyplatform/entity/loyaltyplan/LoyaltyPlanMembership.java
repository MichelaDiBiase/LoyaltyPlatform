package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("membership")
public class LoyaltyPlanMembership extends LoyaltyPlan{

    public LoyaltyPlanMembership(Integer idAgency, Integer registrationCount){
        super(idAgency,registrationCount);
    }

    public LoyaltyPlanMembership() {

    }

}