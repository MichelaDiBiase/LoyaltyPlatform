package it.unicam.cs.ids.loyaltyplatform.controller;


import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Mail;
import it.unicam.cs.ids.loyaltyplatform.service.MailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping(value = "/addMail")
    public void addMail(@RequestBody Mail mail) {

        this.mailService.addMail(mail);
    }

    @DeleteMapping(value = "/deleteMailById/{id}")
    public void deleteMailById(@PathVariable Integer id) {

        this.mailService.deleteMailById(id);
    }

    @GetMapping(value = "/getMailByIdCustomer/{idCustomer}")
    public List<Mail> getMailByIdCustomer(@PathVariable Integer idCustomer) {
        return this.mailService.getMailByIdCustomer(idCustomer);
    }

    @GetMapping(value = "/getMailByIdAgency/{idAgency}")
    public List<Mail> getMailByIdAgency(@PathVariable Integer idAgency) {
        return this.mailService.getMailByIdAgency(idAgency);
    }

    @GetMapping(value = "/getMailByIdCustomerAndIdAgency/{idCustomer}&{idAgency}")
    public List<Mail> getMailByIdCustomerAndIdAgency(@PathVariable Integer idCustomer, @PathVariable Integer idAgency) {
        return this.mailService.getMailByIdCustomerAndIdAgency(idCustomer,idAgency);
    }

    @GetMapping(value = "/getMailByCustomerIdAndAgencyId")
    public List<Mail> getAllMails() {
        return this.mailService.getAllMails();
    }

}
