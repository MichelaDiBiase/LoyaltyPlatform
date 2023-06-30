package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Mail;
import it.unicam.cs.ids.loyaltyplatform.repository.MailRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public void deleteMailById(Integer id) {
        this.mailRepository.delete(getMailById(id));
    }

    public Mail getMailById(Integer id){
        return this.mailRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Mail does not exist"));
    }

    public List<Mail> getMailByIdCustomer(Integer idCustomer){
        return this.mailRepository.findByIdCustomer(idCustomer);
    }
    public List<Mail> getMailByIdAgency(Integer idAgency){
        return this.mailRepository.findByIdAgency(idAgency);
    }

    public List<Mail> getMailByIdCustomerAndIdAgency(Integer idCustomer, Integer idAgency) {
        return this.mailRepository.findByIdCustomerAndIdAgency(idCustomer, idAgency);
    }

    public List<Mail> getAllMails() {
        return this.mailRepository.findAll();
    }
}