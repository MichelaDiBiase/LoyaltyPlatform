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
       if (this.agencyService.getAllAgencies().parallelStream().noneMatch(x->x.getId().equals(loyaltyPlan.getIdAgency()))) {
            throw new EntityNotFoundException("The id(" + loyaltyPlan.getIdAgency() + ") of the agency does not exist");
        }
        this.loyaltyPlanRepository.save(loyaltyPlan);
    }
    public void deleteLoyaltyPlanById(Integer id) {
        if (loyaltyPlanRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the loyaltyPlan does not exist");
        }

        this.loyaltyPlanRepository.deleteById(id);
    }

    public List<LoyaltyPlan> getAllLoyaltyPlan(){
        return this.loyaltyPlanRepository.findAll();
    }

    public List<LoyaltyPlan> getLoyaltyPlanByIdAgency(Integer idAgency){
        if (this.agencyService.getAllAgencies().parallelStream().noneMatch(x->x.getId().equals(idAgency))) {
            throw new EntityNotFoundException("The id(" + idAgency + ") of the agency does not exist");
        }
        return this.loyaltyPlanRepository.findByIdAgency(idAgency);
    }

    public LoyaltyPlan getLoyaltyPlanById(Integer id){
        if (loyaltyPlanRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the loyaltyPlan does not exist");
        }
        return this.loyaltyPlanRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("The id "+id+" does not corresponds to any  LoyaltyPlanById "));
    }

}
