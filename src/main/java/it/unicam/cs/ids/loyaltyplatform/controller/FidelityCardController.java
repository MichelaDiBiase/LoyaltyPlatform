package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.service.CustomerService;
import it.unicam.cs.ids.loyaltyplatform.service.FidelityCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fidelityCard")
public class FidelityCardController {
    private final FidelityCardService fidelityCardService;

    public FidelityCardController(FidelityCardService fidelityCardService, CustomerService customerService) {
        this.fidelityCardService = fidelityCardService;
    }

    @PostMapping(value = "/addPremiumCustomer")
    public void addPremiumCustomer(@RequestBody FidelityCard fidelityCard) {
        this.fidelityCardService.addPremiumCustomer(fidelityCard);
    }

    @DeleteMapping(value = "/deleteCustomerById")
    public void deletePremiumCustomerById(@PathVariable("id") Integer idCustomer) {
        this.fidelityCardService.deletePremiumCustomerById(idCustomer);
    }

    @GetMapping(value = "/getCustomerById")
    public FidelityCard getCustomerByFidelityCardId(@PathVariable("id") Integer idFidelityCard) {
        return this.fidelityCardService.getCustomerByFidelityCardId(idFidelityCard);
    }

    @GetMapping(value = "/getAllCustomersWithFidelityCard")
    public List<FidelityCard> getAllCustomersWithFidelityCard() {
        return this.fidelityCardService.getAllCustomersWithFidelityCard();
    }

}
