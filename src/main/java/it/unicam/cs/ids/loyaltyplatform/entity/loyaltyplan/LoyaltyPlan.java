package it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "loyaltyplan")
public class LoyaltyPlan {
    @Id
    @Column(nullable = false,unique = true)
    private Integer id;

    @Column(nullable = false)
    private Integer idAgency;

    @Column()
    private Integer registrationCount;

    public LoyaltyPlan(Integer idAgency, Integer registrationCount){
        this.idAgency=idAgency;
        this.registrationCount=registrationCount;
    }

    public LoyaltyPlan() {

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
