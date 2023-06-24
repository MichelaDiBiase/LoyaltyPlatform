package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.Coupon;
import it.unicam.cs.ids.loyaltyplatform.repository.CouponRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public void deleteCouponByCode(Integer code) {
        if(couponRepository.findAll().parallelStream().noneMatch(x -> x.getCode().equals(code))) {
            throw new EntityNotFoundException("The id(" + code + ") of the Coupon to delete does not exist");
        }
        this.couponRepository.deleteById(code);
    }

    public void updateCoupon(Integer code, Coupon coupon) {
        Coupon co = this.couponRepository.findById(code).orElseThrow(() -> new EntityNotFoundException("The id(" + code + ") of the Coupon to update does not exist"));
        co.setPoints(coupon.getPoints());
        co.setDiscount(coupon.getDiscount());
        co.setIdCustomer(coupon.getIdCustomer());
        co.setIdAgency(coupon.getIdAgency());
        this.couponRepository.saveAndFlush(co);
    }

    public Coupon getCouponByCode(Integer code) {
        return this.couponRepository.findById(code).orElseThrow(() -> new EntityNotFoundException("The id(" + code + ") of the Coupon to get does not exist"));
    }

    public List<Coupon> getCouponsByIdCustomer(Integer idCustomer) {
        return this.couponRepository.findByIdCustomer(idCustomer);
    }

    public List<Coupon> getCouponsByIdAgency(Integer idAgency) {
        return this.couponRepository.findByIdAgency(idAgency);
    }

    public List<Coupon> getAllCoupons() {
        return this.couponRepository.findAll();
    }
}
