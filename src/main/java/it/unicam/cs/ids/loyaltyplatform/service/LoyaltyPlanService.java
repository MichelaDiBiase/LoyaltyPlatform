package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.*;
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

    public boolean isLoyaltyPlanExist(LoyaltyPlan loyaltyPlan) {
        List<LoyaltyPlan> listOfLP = getLoyaltyPlanByIdAgency(loyaltyPlan.getIdAgency());
        for(LoyaltyPlan lp : listOfLP) {
            if (loyaltyPlan instanceof LoyaltyPlanLevels && lp instanceof LoyaltyPlanLevels) {
                return true;
            }
            if (loyaltyPlan instanceof LoyaltyPlanMembership && lp instanceof LoyaltyPlanMembership) {
                return true;
            }
            if (loyaltyPlan instanceof LoyaltyPlanPoints && lp instanceof LoyaltyPlanPoints) {
                return true;
            }
            if (loyaltyPlan instanceof LoyaltyPlanCashback && lp instanceof LoyaltyPlanCashback) {
                return true;
            }
            if (loyaltyPlan instanceof LoyaltyPlanCoalition && lp instanceof LoyaltyPlanCoalition) {
                return true;
            }
        }
        return false;
    }

    public void addLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
        if (this.agencyService.getAllAgencies().parallelStream().noneMatch(x->x.getId().equals(loyaltyPlan.getIdAgency()))) {
            throw new EntityNotFoundException("The id(" + loyaltyPlan.getIdAgency() + ") of the agency does not exist");
        }
        if(isLoyaltyPlanExist(loyaltyPlan)) {
            throw new IllegalArgumentException("The type of the loyalty plan to create already exist for this agency");
        }
        loyaltyPlan.setRegistrationCount(0);
        this.agencyService.addLoyaltyPlanToAgency(loyaltyPlan.getIdAgency(), loyaltyPlan);
        this.loyaltyPlanRepository.save(loyaltyPlan);
    }
    public void deleteLoyaltyPlanById(Integer id) {
        if (loyaltyPlanRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the loyaltyPlan does not exist");
        }
        LoyaltyPlan loyaltyPlan = getLoyaltyPlanById(id);
        this.agencyService.removeLoyaltyPlanFromAgency(loyaltyPlan.getIdAgency(), loyaltyPlan);
        this.loyaltyPlanRepository.deleteById(id);
    }

    public void updateLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
        LoyaltyPlan l = getLoyaltyPlanById(loyaltyPlan.getId());
        l.setRegistrationCount(loyaltyPlan.getRegistrationCount());
        this.loyaltyPlanRepository.saveAndFlush(l);
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