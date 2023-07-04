package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Coupon;
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
    public void addCoupon(@RequestBody Coupon coupon) {
        this.couponService.addCoupon(coupon);
    }

    @DeleteMapping(value = "/deleteCouponByCode/{code}")
    public void deleteCouponByCode(@PathVariable Integer code) {
        this.couponService.deleteCouponByCode(code);
    }

    @PutMapping(value = "/updateAgency/{code}")
    public void updateCoupon(@PathVariable Integer code, @RequestBody Coupon coupon) {
        this.couponService.updateCoupon(code, coupon);
    }

    @GetMapping(value = "/getCouponByCode/{code}")
    public Coupon getCouponByCode(@PathVariable Integer code) {
        return this.couponService.getCouponByCode(code);
    }

    @GetMapping(value = "/getCouponsByIdCustomer/{idCustomer}")
    public List<Coupon> getCouponsByIdCustomer(@PathVariable Integer idCustomer) {
        return this.couponService.getCouponsByIdCustomer(idCustomer);
    }

    @GetMapping(value = "/getCouponsByIdAgency/{idAgency}")
    public List<Coupon> getCouponsByIdAgency(@PathVariable Integer idAgency) {
        return this.couponService.getCouponsByIdAgency(idAgency);
    }

    @GetMapping(value = "/getAllCoupons")
    public List<Coupon> getAllCoupons() {
        return this.couponService.getAllCoupons();
    }
}
