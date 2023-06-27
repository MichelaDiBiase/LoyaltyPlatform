package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Catalog;
import it.unicam.cs.ids.loyaltyplatform.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
     
        
    }
    @PostMapping(value = "/addCatalog")
    public void addCatalog(@RequestBody Catalog catalog) {

        this.catalogService.addCatalog(catalog);
    }

    @DeleteMapping(value = "/deleteCatalog")
    public void deleteCatalog(@PathVariable("catalog") Catalog catalog) {

        this.catalogService.deleteCatalog(catalog);
    }
    @PutMapping(value = "/updateCatalog")
    public void updateCatalog(@RequestBody Catalog catalog) {

        this.catalogService.updateCatalog(catalog);
    }
    @GetMapping(value = "/getCatalogByProductId")
    public List<Catalog> getCatalogByProductId(Integer idProduct) {
        return this.catalogService.getCatalogByProductId(idProduct);
    }

}