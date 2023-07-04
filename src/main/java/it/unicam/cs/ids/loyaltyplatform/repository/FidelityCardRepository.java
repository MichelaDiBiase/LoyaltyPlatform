package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.FidelityCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FidelityCardRepository extends JpaRepository<FidelityCard, Integer> {
    Optional<FidelityCard> findByIdCustomer(Integer idCustomer);

}
