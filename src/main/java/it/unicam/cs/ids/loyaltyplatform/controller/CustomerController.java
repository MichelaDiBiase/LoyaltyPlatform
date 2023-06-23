package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.service.CustomerService;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        this.customerService.updateCustomer(id, customer);
    }

    @PutMapping(value = "/addPointsToCustomerById/{id}/points/{points}")
    public void addPointsToCustomerById(@PathVariable Integer id, @PathVariable Integer points) {
        this.customerService.addPointsToCustomerById(id, points);
    }

    @PutMapping(value = "/updateCustomerToPremium/{id}")
    public void updateCustomerToPremium(Integer id) {
        this.customerService.updateCustomerToPremium(id);
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
