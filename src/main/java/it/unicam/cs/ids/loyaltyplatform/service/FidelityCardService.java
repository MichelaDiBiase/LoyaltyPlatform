package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.repository.FidelityCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class FidelityCardService {
    private final FidelityCardRepository fidelityCardRepository;
    private final CustomerService customerService;

    public FidelityCardService(FidelityCardRepository fidelityCardRepository, CustomerService customerService) {
        this.fidelityCardRepository = fidelityCardRepository;
        this.customerService = customerService;
    }

    public void addPremiumCustomer(FidelityCard fidelityCard) {
        this.fidelityCardRepository.save(fidelityCard);
    }

    public void deletePremiumCustomerById(Integer idCustomer) {
        this.fidelityCardRepository.deleteById(idCustomer);
    }

    public FidelityCard getCustomerByFidelityCardId(Integer idFidelityCard) {
        return this.fidelityCardRepository.findById(idFidelityCard).orElseThrow(NullPointerException::new);
    }

    public List<FidelityCard> getAllCustomersWithFidelityCard() {
        return this.fidelityCardRepository.findAll();
    }


}
