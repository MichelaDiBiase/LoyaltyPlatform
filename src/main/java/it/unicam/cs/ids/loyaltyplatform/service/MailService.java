package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Mail;
import it.unicam.cs.ids.loyaltyplatform.repository.MailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {
    private final MailRepository mailRepository;

    public MailService(MailRepository mailRepository) {

        this.mailRepository = mailRepository;
    }
    public void addMail(Mail mail) {

         this.mailRepository.save(mail);
    }
    public void deleteMail(Mail mail) {

        this.mailRepository.delete(mail);
    }
    public List<Mail> getMailByCustomerId(Integer idCustomer){
        return this.mailRepository.findAll().parallelStream().filter(x -> x.getIdCostumer()==(idCustomer)).toList();
    }
    public List<Mail> getMailByAgencyId(Integer idAgency){
        return this.mailRepository.findAll().parallelStream().filter(x -> x.getIdAgency()==(idAgency)).toList();
    }

    public List<Mail> getMailByCustomerIdAndAgencyId(Integer idCustomer, Integer idAgency) {
        return this.mailRepository.findAll().parallelStream().filter(x -> x.getIdCostumer() == idCustomer && x.getIdAgency() == idAgency).toList();
    }

}