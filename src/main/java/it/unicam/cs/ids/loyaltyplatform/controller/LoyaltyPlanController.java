package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.service.LoyaltyPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class LoyaltyPlanController {

    private final LoyaltyPlanService loyaltyPlanService;

    public LoyaltyPlanController(LoyaltyPlanService loyaltyPlanService) {
        this.loyaltyPlanService = loyaltyPlanService;
    }

    @PostMapping(value = "/addLoyaltyPlan")
    public void addLoyaltyPlan(@RequestBody LoyaltyPlan loyaltyPlan) {

        this.loyaltyPlanService.addLoyaltyPlan(loyaltyPlan);
    }

    @DeleteMapping(value = "/deleteLoyaltyPlan/{loyaltyPlan}")
    public void deleteLoyaltyPlan(@PathVariable LoyaltyPlan loyaltyPlan) {

        this.loyaltyPlanService.deleteLoyaltyPlan(loyaltyPlan);
    }

    @GetMapping(value = "/getLoyaltyPlanByIdAgency/{idAgency}")
    public List<LoyaltyPlan> getLoyaltyPlanByIdAgency(@PathVariable Integer idAgency) {
        return this.loyaltyPlanService.getLoyaltyPlanByIdAgency(idAgency);
    }

    @GetMapping(value = "/getLoyaltyPlanById/{id}")
    public Optional<LoyaltyPlan> getLoyaltyPlanById(@PathVariable Integer id) {
        return this.loyaltyPlanService.getLoyaltyPlanById(id);
    }

    @GetMapping(value = "/getAllLoyaltyPlan")
    public List<LoyaltyPlan> getAllLoyaltyPlan() {
        return this.loyaltyPlanService.getAllLoyaltyPlan();
    }

}
