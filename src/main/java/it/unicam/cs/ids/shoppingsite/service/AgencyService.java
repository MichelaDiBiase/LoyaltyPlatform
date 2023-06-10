package it.unicam.cs.ids.shoppingsite.service;

import it.unicam.cs.ids.shoppingsite.entity.users.Agency;
import it.unicam.cs.ids.shoppingsite.repository.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private final AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public Agency getAgencyById(Integer id) {
        return this.agencyRepository.findById(id).orElseThrow(NullPointerException::new);
    }
    public List<Agency> getAllAgencies() {
        return this.agencyRepository.findAll();
    }
    public Agency addAgency(Agency agency) {
        return this.agencyRepository.save(agency);
    }
    public void deleteAgency(Agency agency) {
        this.agencyRepository.delete(agency);
    }
}
