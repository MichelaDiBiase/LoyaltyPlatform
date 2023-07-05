package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.service.CustomerService;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.service.RegistrationLoyaltyPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final RegistrationLoyaltyPlanService registrationService;

    public CustomerController(CustomerService customerService, RegistrationLoyaltyPlanService registrationService) {
        this.customerService = customerService;
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/addCustomer")
    public void addCustomer(@RequestBody Customer customer) {
        this.customerService.addCustomer(customer);
    }

    @DeleteMapping(value = "/deleteCustomerById/{id}")
    public void deleteCustomerById(@PathVariable Integer id) {
        this.customerService.deleteCustomerById(id);
    }

    @PutMapping(value = "/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer) {
        this.customerService.updateCustomer(customer);
    }

    @PutMapping(value = "/addPointsToCustomerById/{id}/points/{points}")
    public void addPointsToCustomerById(@PathVariable Integer id, @PathVariable Integer points) {
        this.customerService.addPointsToCustomerById(id, points);
    }

    @PostMapping(value = "/redeemReward/{idProduct}/idRegistration/{idRegistration}")
    public void redeemReward(@PathVariable Integer idProduct, @PathVariable Integer idRegistration){
       this.registrationService.redeemProduct(idProduct, idRegistration);

    }

    @GetMapping(value = "/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return this.customerService.getCustomerById(id);
    }

    @GetMapping(value = "/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

}
