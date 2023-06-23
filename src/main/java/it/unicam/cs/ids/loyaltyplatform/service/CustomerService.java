package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
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
        if(customerRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the Customer to delete does not exist");
        }
        this.customerRepository.deleteById(id);
    }

    public void updateCustomer(Integer id, Customer customer) {
        Customer c = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This id(" + id + ") does not corresponds to any Customer"));
        c.setName(customer.getName());
        c.setSurname(customer.getSurname());
        c.setGender(customer.getGender());
        c.setEmail(customer.getEmail());
        c.setPassword(customer.getPassword());
        this.customerRepository.saveAndFlush(c);
    }

    public void addPointsToCustomerById(Integer id, Integer points) {
        if(customerRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the Customer does not exist");
        }
        getCustomerById(id).sumPoints(points);
    }

    public Customer getCustomerById(Integer id) {
        return this.customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The id(" + id + ") of the Customer to get does not exist"));
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
}
