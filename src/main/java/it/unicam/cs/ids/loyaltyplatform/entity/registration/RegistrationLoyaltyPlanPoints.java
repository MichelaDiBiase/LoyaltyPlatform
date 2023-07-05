package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("points")
@NoArgsConstructor
public class RegistrationLoyaltyPlanPoints extends RegistrationLoyaltyPlan {

    @JoinColumn(name = "idProduct")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> redeemedProducts;

    public RegistrationLoyaltyPlanPoints(Integer idCustomer, Integer idLoyaltyPlan) {
        super(idCustomer, idLoyaltyPlan);
        this.redeemedProducts = new ArrayList<>();
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
