package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.repository.LoyaltyPlanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoyaltyPlanService {
    private final LoyaltyPlanRepository loyaltyPlanRepository;
    private final AgencyService agencyService;

    public LoyaltyPlanService(LoyaltyPlanRepository loyaltyPlanRepository, AgencyService agencyService) {
        this.loyaltyPlanRepository = loyaltyPlanRepository;
        this.agencyService = agencyService;
    }

    public void addLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
      //  if (this.agencyService.getAgencyById(loyaltyPlan.getId())) {
        //    throw new EntityNotFoundException("The id(" + loyaltyPlan.getIdAgency() + ") of the id does not exist");
      //  }
        this.loyaltyPlanRepository.save(loyaltyPlan);
    }
    public void deleteLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
        if (loyaltyPlanRepository.findAll().parallelStream().noneMatch(x -> x.getIdAgency().equals(loyaltyPlan.getIdAgency()))) {
            throw new EntityNotFoundException("The id(" + loyaltyPlan.getIdAgency() + ") of the id does not exist");
        }

        this.loyaltyPlanRepository.delete(loyaltyPlan);
    }

    public List<LoyaltyPlan> getAllLoyaltyPlan(){
        return this.loyaltyPlanRepository.findAll();
    }

    public List<LoyaltyPlan> getLoyaltyPlanByIdAgency(Integer idAgency){
        return this.loyaltyPlanRepository.findByIdAgency(idAgency);
    }

    public List<LoyaltyPlan> getLoyaltyPlanById(Integer id){
        return this.loyaltyPlanRepository.findById(id);
    }

}
