package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.RegistrationLoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.repository.RegistrationLoyaltyPlanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationLoyaltyPlanService {
    private final RegistrationLoyaltyPlanRepository registrationRepository;
    private final CustomerService customerService;

    public RegistrationLoyaltyPlanService(RegistrationLoyaltyPlanRepository registrationRepository, CustomerService customerService) {
        this.registrationRepository = registrationRepository;
        this.customerService = customerService;
    }

    public void addRegistration(RegistrationLoyaltyPlan registration) {
        this.registrationRepository.save(registration);
        this.customerService.updateRegistrationOfCustomer(registration.getIdCustomer(), registration.getLoyaltyPlan());
    }

    public void deleteRegistrationById(Integer id) {
        this.customerService.downgradeRegistrationOfCustomer(getRegistrationById(id).getIdCustomer(), getRegistrationById(id).getLoyaltyPlan());
        this.registrationRepository.deleteById(id);
    }

    public RegistrationLoyaltyPlan getRegistrationById(Integer id){
        return this.registrationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The registration with " + id + " id does not exist"));
    }

    public List<RegistrationLoyaltyPlan> getRegistrationByIdCustomer(Integer idCustomer){
        return this.registrationRepository.findByIdCustomer(idCustomer);
    }

    public List<RegistrationLoyaltyPlan> getAllRegistrations(){
        return this.registrationRepository.findAll();
    }

}
