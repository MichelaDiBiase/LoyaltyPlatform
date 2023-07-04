package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@Entity
@Table(name = "loyaltyPlan")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LoyaltyPlanPoints.class, name = "points"),
        @JsonSubTypes.Type(value = LoyaltyPlanLevels.class, name = "levels"),
        @JsonSubTypes.Type(value = LoyaltyPlanCashback.class, name = "cashback"),
        @JsonSubTypes.Type(value = LoyaltyPlanCoalition.class, name = "coalition"),
        @JsonSubTypes.Type(value = LoyaltyPlanMembership.class, name = "membership")
})
public abstract class LoyaltyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer idAgency;

    @Column()
    private Integer registrationCount;

    public LoyaltyPlan(Integer idAgency){
        this.idAgency=idAgency;
        this.registrationCount=0;
    }

    public LoyaltyPlan() {

    }

    public void incrementRegistrationCount() {
        registrationCount++;
    }

    public void decreaseRegistrationCount() {
        registrationCount--;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(Integer idAgency) {
        this.idAgency = idAgency;
    }

    public Integer getRegistrationCount() {
        return registrationCount;
    }

    public void setRegistrationCount(Integer registrationCount) {
        this.registrationCount = registrationCount;
    }
}