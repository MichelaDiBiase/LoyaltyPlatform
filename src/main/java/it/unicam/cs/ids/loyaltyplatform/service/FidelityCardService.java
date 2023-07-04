package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlanMembership;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.repository.FidelityCardRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FidelityCardService {
    private final FidelityCardRepository fidelityCardRepository;
    private final CustomerService customerService;

    public FidelityCardService(FidelityCardRepository fidelityCardRepository, CustomerService customerService, LoyaltyPlanService loyaltyPlanService) {
        this.fidelityCardRepository = fidelityCardRepository;
        this.customerService = customerService;
    }

    public void addFidelityCard(FidelityCard fidelityCard) {
        if(this.fidelityCardRepository.findByIdCustomer(fidelityCard.getIdCustomer()).isPresent()) {
            throw new EntityExistsException("Customer (id: " + fidelityCard.getIdCustomer() + ") has already a Fidelity Card");
        }
        if(this.customerService.getAllCustomers().parallelStream().noneMatch(x -> x.getId().equals(fidelityCard.getIdCustomer()))) {
            throw new EntityNotFoundException("Customer (id: " + fidelityCard.getIdCustomer() + ") does not exist");
        }
        if(this.customerService.getAllRegistrationByIdCustomer(fidelityCard.getIdCustomer()).parallelStream().noneMatch(x -> x.getLoyaltyPlan() instanceof LoyaltyPlanMembership)) {
            throw new EntityNotFoundException("Customer (id: " + fidelityCard.getIdCustomer() + ") is not registered to loyalty plan Membership");
        }
        this.fidelityCardRepository.save(fidelityCard);
    }

    public void deleteFidelityCardById(Integer id) {
        this.fidelityCardRepository.deleteById(id);
    }

    public FidelityCard getFidelityCard(Integer idFidelityCard) {
        return this.fidelityCardRepository.findById(idFidelityCard).orElseThrow(() -> new EntityNotFoundException("The id(" + idFidelityCard + ") of the Fidelity Card to get does not exist"));
    }

    public FidelityCard getFidelityCardByIdCustomer(Integer idCustomer) {
        return this.fidelityCardRepository.findByIdCustomer(this.customerService.getCustomerById(idCustomer).getId()).orElseThrow(() -> new EntityNotFoundException("The Customer (id: " + idCustomer + ") has no Fidelity Card"));
    }

    public List<FidelityCard> getAllCustomersWithFidelityCard() {
        return this.fidelityCardRepository.findAll();
    }

}
