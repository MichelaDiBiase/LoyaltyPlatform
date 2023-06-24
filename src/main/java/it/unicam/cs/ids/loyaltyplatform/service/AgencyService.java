package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Agency;
import it.unicam.cs.ids.loyaltyplatform.repository.AgencyRepository;
import jakarta.persistence.EntityNotFoundException;
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
        if(agencyRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the Agency to delete does not exist");
        }
        this.agencyRepository.deleteById(id);
    }

    public void updateAgency(Integer id, Agency agency) {
        Agency ag = agencyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This id(" + id + ") does not corresponds to any Agency"));
        ag.setName(agency.getName());
        ag.setEmail(agency.getEmail());
        ag.setPassword(agency.getPassword());
        agencyRepository.saveAndFlush(ag);
    }

    public Agency getAgencyById(Integer id) {
        if(agencyRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the Agency to get does not exist");
        }
        return this.agencyRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Agency> getAllAgencies() {
        return this.agencyRepository.findAll();
    }
}
