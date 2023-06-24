package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.FidelityCard;
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

    @DeleteMapping(value = "/deleteCustomerById/{idCustomer}")
    public void deletePremiumCustomerById(@PathVariable Integer idCustomer) {
        this.fidelityCardService.deletePremiumCustomerById(idCustomer);
    }

    @GetMapping(value = "/getCustomerById/{idFidelityCard}")
    public FidelityCard getCustomerByFidelityCardId(@PathVariable Integer idFidelityCard) {
        return this.fidelityCardService.getFidelityCard(idFidelityCard);
    }

    @GetMapping(value = "/getFidelityCardByIdCustomer/{idCustomer}")
    public FidelityCard getFidelityCardByIdCustomer(@PathVariable Integer idCustomer) {
        return this.fidelityCardService.getFidelityCardByIdCustomer(idCustomer);
    }

    @GetMapping(value = "/getAllCustomersWithFidelityCard")
    public List<FidelityCard> getAllCustomersWithFidelityCard() {
        return this.fidelityCardService.getAllCustomersWithFidelityCard();
    }

}
