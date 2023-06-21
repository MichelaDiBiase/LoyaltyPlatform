package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.Coupon;
import it.unicam.cs.ids.loyaltyplatform.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponRepository) {
        this.couponService = couponRepository;
    }

    @PostMapping(value = "/addCoupon")
    public void addCoupon(Coupon coupon) {
        this.couponService.addCoupon(coupon);
    }

    @DeleteMapping(value = "/deleteCouponById")
    public void deleteCouponById(Integer code) {
        this.couponService.deleteCouponById(code);
    }

    @PutMapping(value = "/updateAgency")
    public void updateCoupon(Coupon coupon) {
        this.couponService.deleteCouponById(coupon.getCode());
        addCoupon(coupon);
    }

    @GetMapping(value = "/getCouponById")
    public Coupon getCouponById(Integer code) {
        return this.couponService.getCouponById(code);
    }

    @GetMapping(value = "/getCouponsByCustomerId")
    public List<Coupon> getCouponsByCustomerId(Integer idCustomer) {
        return this.couponService.getCouponsByCustomerId(idCustomer);
    }

    @GetMapping(value = "/getCouponsByAgencyId")
    public List<Coupon> getCouponsByAgencyId(Integer idAgency) {
        return this.couponService.getCouponsByAgencyId(idAgency);
    }

    @GetMapping(value = "/getAllCoupons")
    public List<Coupon> getAllCoupons() {
        return this.couponService.getAllCoupons();
    }
}
