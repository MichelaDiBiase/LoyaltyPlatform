package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.service.AgencyService;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Agency;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
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

    @GetMapping(value = "/getAgencyById/{id}")
    public Agency getAgencyById(@PathVariable Integer id) {
        return this.agencyService.getAgencyById(id);
    }

    @GetMapping(value = "/getAllAgencies")
    public List<Agency> getAllAgencies() {
        return this.agencyService.getAllAgencies();
    }

}
