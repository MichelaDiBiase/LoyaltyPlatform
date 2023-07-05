package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Coupon;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("levels")
@NoArgsConstructor
public class RegistrationLoyaltyPlanLevels extends RegistrationLoyaltyPlan {

    private Integer level;
    private Double moneySpent;
    @JoinColumn(name = "idCoupon")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Coupon> coupons;

    public RegistrationLoyaltyPlanLevels(Integer idCustomer, Integer idLoyaltyPlan, Double moneySpent) {
        super(idCustomer, idLoyaltyPlan);
        this.level = 0;
        this.moneySpent = moneySpent;
    }

    public void incrementLevel() {
        int i = 1;
        while (moneySpent >= 100 * i) {
            level = i;
            Coupon coupon = new Coupon(5.0);
            addCoupon(coupon);
        }
    }

    public void calculateMoneySpent(Double money) {
        moneySpent += money;
        incrementLevel();
    }

    public void addCoupon(Coupon coupon) {
        coupons.add(coupon);
    }

    public void removeCoupon(Coupon coupon) {
        coupons.add(coupon);
    }


    public Integer getLevel() {
        return level;
    }

    public Double getMoneySpent() {
        return moneySpent;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setMoneySpent(Double moneySpent) {
        this.moneySpent = moneySpent;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}
