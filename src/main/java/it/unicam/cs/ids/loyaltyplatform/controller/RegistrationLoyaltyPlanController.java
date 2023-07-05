package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.registration.RegistrationLoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.service.RegistrationLoyaltyPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping(value = "/getRegistrationsByIdLoyaltyPlan/{idLoyaltyPlan}")
    public List<RegistrationLoyaltyPlan> getRegistrationsByIdLoyaltyPlan(@PathVariable Integer idLoyaltyPlan){
        return this.registrationService.getRegistrationsByIdLoyaltyPlan(idLoyaltyPlan);
    }

    @GetMapping(value = "/getRegistrationsByIdCustomer/{idCustomer}")
    public List<RegistrationLoyaltyPlan> getRegistrationsByIdCustomer(@PathVariable Integer idCustomer){
        return this.registrationService.getRegistrationsByIdCustomer(idCustomer);
    }

    @GetMapping(value = "/getAllRegistrations")
    public List<RegistrationLoyaltyPlan> getAllRegistrations(){
        return this.registrationService.getAllRegistrations();
    }
}
