package it.unicam.cs.ids.loyaltyplatform.repository;


import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
