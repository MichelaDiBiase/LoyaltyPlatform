package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Agency;
import it.unicam.cs.ids.loyaltyplatform.repository.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private final AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public void addAgency(Agency agency) {
        this.agencyRepository.save(agency);
    }

    public void deleteAgencyById(Integer id) {
        this.agencyRepository.deleteById(id);
    }

    public void updateAgency(Agency agency) {
        this.agencyRepository.saveAndFlush(agency);
    }

    public Agency getAgencyById(Integer id) {
        return this.agencyRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Agency> getAllAgencies() {
        return this.agencyRepository.findAll();
    }
}
