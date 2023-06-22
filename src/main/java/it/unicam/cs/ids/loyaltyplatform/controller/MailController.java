package it.unicam.cs.ids.loyaltyplatform.controller;


import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Mail;
import it.unicam.cs.ids.loyaltyplatform.service.MailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping(value = "/addMail")
    public void addMail(@RequestBody Mail mail) {

        this.mailService.addMail(mail);
    }

    @DeleteMapping(value = "/deleteMail")
    public void deleteMail(@PathVariable("text") Mail text) {

        this.mailService.deleteMail(text);
    }

    @GetMapping(value = "/getMailByCustomerId")
    public List<Mail> getMailByCustomerId(Integer idCustomer) {
        return this.mailService.getMailByCustomerId(idCustomer);
    }

    @GetMapping(value = "/getMailByAgencyId")
    public List<Mail> getMailByAgencyId(Integer idAgency) {
        return this.mailService.getMailByAgencyId(idAgency);
    }

    @GetMapping(value = "/getMailByCustomerIdAndAgencyId")
    public List<Mail> getMailByCustomerIdAndAgencyId(Integer idCustomer, Integer idAgency) {
        return this.mailService.getMailByCustomerIdAndAgencyId(idCustomer,idAgency);
    }


}
