package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.registration.RegistrationLoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void updateRegistrationOfCustomer(Integer id, RegistrationLoyaltyPlan registration) {
        Customer c = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This id(" + id + ") does not corresponds to any Customer"));
        c.addRegistration(registration);
    }

    public void downgradeRegistrationOfCustomer(Integer id, RegistrationLoyaltyPlan registration) {
        Customer c = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This id(" + id + ") does not corresponds to any Customer"));
        if(!c.checkRegistration(registration)) {
            throw new EntityNotFoundException("The LoyaltyPlan(id:" + registration.getId() + ") to remove from customer(id:" + id + ") does not exist");
        }
        c.removeRegistration(registration);
        this.customerRepository.saveAndFlush(c);
    }

    public void addCustomer(Customer customer) {
        customer.setPoints(0);
        customer.setPremium(false);
        this.customerRepository.save(customer);
    }

    public void deleteCustomerById(Integer id) {
        if(customerRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the Customer to delete does not exist");
        }
        this.customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        Customer c = getCustomerById(customer.getId());
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
        if(points <= 0) {
            throw new NoResultException("The points(" + id + ") cannot be added");
        }
        getCustomerById(id).sumPoints(points);
        customerRepository.saveAndFlush(getCustomerById(id));
    }

    public Customer getCustomerById(Integer id) {
        return this.customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The id(" + id + ") of the Customer to get does not exist"));
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
}
