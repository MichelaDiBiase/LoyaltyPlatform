package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "registrations")
public class RegistrationLoyaltyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,
            nullable = false)
    private Integer idCustomer;
    @JoinColumn(name = "idLoyaltyPlan")
    private LoyaltyPlan loyaltyPlan;
    private LocalDate date;

    public RegistrationLoyaltyPlan(Integer idCustomer, LoyaltyPlan loyaltyPlan, LocalDate date) {
        this.idCustomer = idCustomer;
        this.loyaltyPlan = loyaltyPlan;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public LoyaltyPlan  getLoyaltyPlan() {
        return loyaltyPlan;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
        this.loyaltyPlan = loyaltyPlan;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
