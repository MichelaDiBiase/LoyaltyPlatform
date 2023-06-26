package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Review;
import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.FidelityCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByName(String name);
}
