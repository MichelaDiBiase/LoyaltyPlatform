package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.repository.MailRepository;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final MailRepository mailRepository;

    public MailService(MailRepository mailRepository) {

        this.mailRepository = mailRepository;
    }
}