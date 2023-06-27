package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Mail;
import it.unicam.cs.ids.loyaltyplatform.repository.MailRepository;
import jakarta.persistence.EntityExistsException;
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
        if(this.mailRepository. findByMail(mail.getRecipient()).isPresent()) {
            throw new EntityExistsException("Mail " + mail.getRecipient() + "it already exists");
        }

         this.mailRepository.save(mail);
    }
    public void deleteMail(Mail mail) {
        if(mailRepository.findAll().parallelStream().noneMatch(x -> x.getClass().equals(mail))) {
            throw new EntityNotFoundException("The (" + mail + ") of the mail to delete does not exist");
        }

        this.mailRepository.delete(mail);
    }
    public List<Mail> getMailByCustomerId(Integer idCustomer){
        if(mailRepository.findAll().parallelStream().noneMatch(x -> x.getIdCostumer().equals(idCustomer))) {
            throw new EntityNotFoundException("The id(" + idCustomer + ") of the id does not exist");
        }
        return this.mailRepository.findAll().parallelStream().filter(x -> x.getIdCostumer()==(idCustomer)).toList();
    }
    public List<Mail> getMailByAgencyId(Integer idAgency){

        return this.mailRepository.findAll().parallelStream().filter(x -> x.getIdAgency()==(idAgency)).toList();
    }

    public List<Mail> getMailByCustomerIdAndAgencyId(Integer idCustomer, Integer idAgency) {
        return this.mailRepository.findAll().parallelStream().filter(x -> x.getIdCostumer() == idCustomer && x.getIdAgency() == idAgency).toList();
    }

}