package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import it.unicam.cs.ids.loyaltyplatform.service.CatalogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {


    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;


    }
    @PostMapping(value = "/addProductToCatalog")
    public void addProductToCatalog(@RequestBody Integer idProduct) {
        this.catalogService.addProductToCatalog(idProduct);
    }

    @DeleteMapping(value = "/deleteProductFromCatalog/{idProduct}")
    public void deleteProductFromCatalog(@PathVariable Integer idProduct) {
        this.catalogService.deleteProductFromCatalog(idProduct);
    }
    @PutMapping(value = "/updateCatalog")
    public void updateProductFromCatalog(@RequestBody Product product) {

        this.catalogService.updateProductFromCatalog(product);
    }
    @GetMapping(value = "/getProductFromCatalogByIdProduct/{idProduct}")
    public Product getProductFromCatalogByIdProduct(@PathVariable Integer idProduct) {
        return this.catalogService.getProductFromCatalogByIdProduct(idProduct);
    }

}