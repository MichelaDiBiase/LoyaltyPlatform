package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.service.ProductService;
import it.unicam.cs.ids.loyaltyplatform.entity.shoppingservices.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/getProductById/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {
        return this.productService.getProductById(id);
    }
}
