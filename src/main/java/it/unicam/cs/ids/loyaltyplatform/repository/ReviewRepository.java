package it.unicam.cs.ids.loyaltyplatform.repository;


import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByIdCustomer(Integer idCustomer);
    List<Review> findByIdAgency(Integer idCustomer);
    List<Review> findByIdCustomerAndIdAgency(Integer idCustomer, Integer idAgency);
}