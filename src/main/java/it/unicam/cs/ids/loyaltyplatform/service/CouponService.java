package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.Coupon;
import it.unicam.cs.ids.loyaltyplatform.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public void addCoupon(Coupon coupon) {
        this.couponRepository.save(coupon);
    }

    public void deleteCouponById(Integer code) {
        this.couponRepository.deleteById(code);
    }

    public void updateCoupon(Coupon coupon) {
        this.couponRepository.deleteById(coupon.getCode());
        addCoupon(coupon);
    }

    public Coupon getCouponById(Integer code) {
        return this.couponRepository.findById(code).orElseThrow(NullPointerException::new);
    }

    public List<Coupon> getCouponsByCustomerId(Integer idCustomer) {
        return this.couponRepository.findAll().parallelStream().filter(x -> x.getIdAgency().equals(idCustomer)).toList();
    }

    public List<Coupon> getCouponsByAgencyId(Integer idAgency) {
        return this.couponRepository.findAll().parallelStream().filter(x -> x.getIdAgency().equals(idAgency)).toList();
    }

    public List<Coupon> getAllCoupons() {
        return this.couponRepository.findAll();
    }
}
