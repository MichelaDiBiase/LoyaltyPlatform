package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlan;
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

    public void addLoyaltyPlanToAgency(Integer id, LoyaltyPlan loyaltyPlan) {
        Agency a = getAgencyById(id);
        a.addLoyaltyPlan(loyaltyPlan);
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
        Agency ag = getAgencyById(id);
        ag.setName(agency.getName());
        ag.setEmail(agency.getEmail());
        ag.setPassword(agency.getPassword());
        agencyRepository.saveAndFlush(ag);
    }

    public Agency getAgencyById(Integer id) {
        return this.agencyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The id(" + id + ") of the Agency to get does not exist"));
    }

    public List<Agency> getAllAgencies() {
        return this.agencyRepository.findAll();
    }
}
