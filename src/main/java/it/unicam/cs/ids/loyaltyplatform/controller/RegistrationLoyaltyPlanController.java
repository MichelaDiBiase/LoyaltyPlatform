package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.RegistrationLoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.service.RegistrationLoyaltyPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationLoyaltyPlanController {
    private final RegistrationLoyaltyPlanService registrationService;

    public RegistrationLoyaltyPlanController(RegistrationLoyaltyPlanService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/addRegistration")
    public void addRegistration(@RequestBody RegistrationLoyaltyPlan registration) {
        this.registrationService.addRegistration(registration);
    }

    @DeleteMapping(value = "/deleteRegistrationById/{id}")
    public void deleteRegistrationById(@PathVariable Integer id) {
        this.registrationService.deleteRegistrationById(id);
    }

    @GetMapping(value = "/getRegistrationById/{id}")
    public RegistrationLoyaltyPlan getRegistrationById(@PathVariable Integer id){
        return this.registrationService.getRegistrationById(id);
    }

    @GetMapping(value = "/getRegistrationByIdCustomer/{idCustomer}")
    public List<RegistrationLoyaltyPlan> getRegistrationByIdCustomer(@PathVariable Integer idCustomer){
        return this.registrationService.getRegistrationByIdCustomer(idCustomer);
    }

    @GetMapping(value = "/getAllRegistrations")
    public List<RegistrationLoyaltyPlan> getAllRegistrations(){
        return this.registrationService.getAllRegistrations();
    }
}