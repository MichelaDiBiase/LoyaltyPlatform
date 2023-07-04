package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlanPoints;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("pointsRegistration")
@NoArgsConstructor
public class RegistrationLoyaltyPlanPoints extends RegistrationLoyaltyPlan {

    @JoinColumn(name = "idProduct")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> redeemedProducts;
    public RegistrationLoyaltyPlanPoints(Integer idCustomer, LoyaltyPlanPoints loyaltyPlanPoints, List<Product> redeemedProducts) {
        super(idCustomer, loyaltyPlanPoints);
        this.redeemedProducts = redeemedProducts;
    }

    public void addRedeemedProduct(Product product) {
        redeemedProducts.add(product);
    }

    public List<Product> getRedeemedProducts() {
        return redeemedProducts;
    }

    public void setRedeemedProducts(List<Product> redeemedProducts) {
        this.redeemedProducts = redeemedProducts;
    }
}
