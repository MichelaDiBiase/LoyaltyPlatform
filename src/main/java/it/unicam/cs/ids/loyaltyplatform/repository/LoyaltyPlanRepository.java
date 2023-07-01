package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoyaltyPlanRepository extends JpaRepository<LoyaltyPlan, Integer> {

    List<LoyaltyPlan> findByIdAgency(Integer idAgency);

    List<LoyaltyPlan> findById(Integer id);
}

