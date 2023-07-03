package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.RegistrationLoyaltyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationLoyaltyPlanRepository extends JpaRepository<RegistrationLoyaltyPlan, Integer> {
    List<RegistrationLoyaltyPlan> findByIdCustomer(Integer idCustomer);
}
