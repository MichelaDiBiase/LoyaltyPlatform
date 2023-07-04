package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlan;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "registrations")
public abstract class RegistrationLoyaltyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,
            nullable = false)
    private Integer idCustomer;
    @ManyToOne
    @JoinColumn(name = "idLoyaltyPlan")
    private LoyaltyPlan loyaltyPlan;
    private LocalDate date;

    public RegistrationLoyaltyPlan(Integer idCustomer, LoyaltyPlan loyaltyPlan) {
        this.idCustomer = idCustomer;
        this.loyaltyPlan = loyaltyPlan;
        this.date = LocalDate.now();;
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
