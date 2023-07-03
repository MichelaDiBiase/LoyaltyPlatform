package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoyaltyPlanRepository extends JpaRepository<LoyaltyPlan, Integer> {

    List<LoyaltyPlan> findByIdAgency(Integer idAgency);


}

