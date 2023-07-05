package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.service.AgencyService;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Agency;
import it.unicam.cs.ids.loyaltyplatform.service.LoyaltyPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    private final AgencyService agencyService;
    private final LoyaltyPlanService loyaltyPlanService;

    public AgencyController(AgencyService agencyService, LoyaltyPlanService loyaltyPlanService) {
        this.agencyService = agencyService;
        this.loyaltyPlanService = loyaltyPlanService;
    }

    @PostMapping(value = "/addAgency")
    public void addAgency(@RequestBody Agency agency) {
        this.agencyService.addAgency(agency);
    }

    @DeleteMapping(value = "/deleteAgencyById/{id}")
    public void deleteAgencyById(@PathVariable Integer id) {
        this.agencyService.deleteAgencyById(id);
    }

    @PutMapping(value = "/updateAgency/{id}")
    public void updateAgency(@PathVariable Integer id, @RequestBody Agency agency) {
        this.agencyService.updateAgency(id, agency);
    }

    @PutMapping(value = "/addAgencyToCoalition/agency1/{idAgency1}/agency2/{idAgency2}")
    public void addAgencyToCoalition(@PathVariable Integer idAgency1, @PathVariable Integer idAgency2) {
        this.loyaltyPlanService.addAgencyToCoalition(idAgency1, idAgency2);
    }

    @GetMapping(value = "/getAgencyById/{id}")
    public Agency getAgencyById(@PathVariable Integer id) {
        return this.agencyService.getAgencyById(id);
    }

    @GetMapping(value = "/getAllAgencies")
    public List<Agency> getAllAgencies() {
        return this.agencyService.getAllAgencies();
    }

}
