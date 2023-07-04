package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByIdCustomer(Integer idCustomer);
    List<Coupon> findByIdAgency(Integer idAgency);
}
