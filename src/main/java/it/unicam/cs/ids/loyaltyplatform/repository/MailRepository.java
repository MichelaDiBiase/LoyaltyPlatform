package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Integer> {
}
