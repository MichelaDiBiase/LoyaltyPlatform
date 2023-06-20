package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    public void deleteCustomerById(Integer id) {
        this.customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        this.customerRepository.deleteById(customer.getId());
        addCustomer(customer);
    }

    public Customer getCustomerById(Integer id) {
        return this.customerRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
}
