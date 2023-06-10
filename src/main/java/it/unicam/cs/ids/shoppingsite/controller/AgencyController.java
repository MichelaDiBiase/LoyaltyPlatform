package it.unicam.cs.ids.shoppingsite.controller;

import it.unicam.cs.ids.shoppingsite.service.AgencyService;
import it.unicam.cs.ids.shoppingsite.entity.users.Agency;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AgencyController {
    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping(value = "/getAgencyById/{id}")
    public Agency getAgencyById(@PathVariable("id") Integer id) {
        return this.agencyService.getAgencyById(id);
    }

    @GetMapping(value = "/getAllAgency")
    public List<Agency> getAllAgencies() {
        return this.agencyService.getAllAgencies();
    }

    @PostMapping(value = "/addAgency")
    public Agency addAgency(@RequestBody Agency agency) {
        Agency newAgency = this.agencyService.addAgency(agency);
        return newAgency;
    }

    @DeleteMapping(value = "/deleteAgency")
    public void deleteAgency(@RequestBody Agency agency) {
        this.agencyService.deleteAgency(agency);
    }

}
