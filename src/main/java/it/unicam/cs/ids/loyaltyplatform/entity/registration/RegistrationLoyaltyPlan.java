package it.unicam.cs.ids.loyaltyplatform.entity.registration;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "registrations")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegistrationLoyaltyPlanPoints.class, name = "points"),
        @JsonSubTypes.Type(value = RegistrationLoyaltyPlanLevels.class, name = "levels"),
        @JsonSubTypes.Type(value = RegistrationLoyaltyPlanCashback.class, name = "cashback"),
        @JsonSubTypes.Type(value = RegistrationLoyaltyPlanCoalition.class, name = "coalition"),
        @JsonSubTypes.Type(value = RegistrationLoyaltyPlanMembership.class, name = "membership")
})
public abstract class RegistrationLoyaltyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,
            nullable = false)
    private Integer idCustomer;
    @Column(nullable = false)
    private Integer idLoyaltyPlan;
    private LocalDate date;

    public RegistrationLoyaltyPlan(Integer idCustomer, Integer idLoyaltyPlan) {
        this.idCustomer = idCustomer;
        this.idLoyaltyPlan = idLoyaltyPlan;
        this.date = LocalDate.now();;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public Integer getIdLoyaltyPlan() {
        return idLoyaltyPlan;
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

    public void setIdLoyaltyPlan(Integer idLoyaltyPlan) {
        this.idLoyaltyPlan = idLoyaltyPlan;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
