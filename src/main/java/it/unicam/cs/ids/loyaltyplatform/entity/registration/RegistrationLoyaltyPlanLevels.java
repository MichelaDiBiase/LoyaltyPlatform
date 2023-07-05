package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Coupon;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
        this.level = 1;
        this.moneySpent = moneySpent;
        this.coupons = new ArrayList<>();
    }

    public void incrementLevel(Integer idAgency) {
        while(moneySpent >= 100 * level) {
            level++;
            Coupon coupon = new Coupon(5.0, idAgency, getIdCustomer());
            coupon.setPoints(0);
            addCoupon(coupon);
        }
    }

    public void calculateMoneySpent(Double money, Integer idAgency) {
        moneySpent += money;
        incrementLevel(idAgency);
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
