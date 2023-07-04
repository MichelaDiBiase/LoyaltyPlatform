package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("points")
public class LoyaltyPlanPoints extends LoyaltyPlan {

    public LoyaltyPlanPoints (Integer idAgency, Integer registrationCount){
        super(idAgency,registrationCount);
    }

    public LoyaltyPlanPoints () {

    }
}