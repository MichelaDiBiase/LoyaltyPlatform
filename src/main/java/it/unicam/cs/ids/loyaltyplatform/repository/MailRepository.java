package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {
    List<Mail> findByIdCustomer(Integer idCustomer);
    List<Mail> findByIdAgency(Integer idAgency);
    List<Mail> findByIdCustomerAndIdAgency(Integer idCustomer, Integer idAgency);
}
