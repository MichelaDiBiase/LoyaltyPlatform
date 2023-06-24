package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.repository.FidelityCardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FidelityCardService {
    private final FidelityCardRepository fidelityCardRepository;
    private final CustomerService customerService;

    public FidelityCardService(FidelityCardRepository fidelityCardRepository, CustomerService customerService, AgencyService agencyService) {
        this.fidelityCardRepository = fidelityCardRepository;
        this.customerService = customerService;
    }

    public void addPremiumCustomer(FidelityCard fidelityCard) {
        this.fidelityCardRepository.save(fidelityCard);
        this.customerService.updateCustomerToPremium(fidelityCard.getIdCustomer(), fidelityCard);
    }

    public void deletePremiumCustomerById(Integer idCustomer) {
        this.fidelityCardRepository.deleteById(this.customerService.getCustomerById(idCustomer).getFidelityCard().getId());
        this.customerService.downgradeCustomerAboutPremium(idCustomer);
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
