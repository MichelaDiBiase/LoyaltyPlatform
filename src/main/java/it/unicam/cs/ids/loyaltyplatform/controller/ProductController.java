package it.unicam.cs.ids.loyaltyplatform.controller;

import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.service.ProductService;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping(value = "/getProductById/{id}")
    public Product getProductById(@PathVariable Integer id) {

        return this.productService.getProductById(id);
    }

    @PostMapping(value = "/addProduct")
    public void addProduct(@RequestBody Product product) {

        this.productService.addProduct(product);
    }

    @DeleteMapping(value = "/deleteProductById/{id}")
    public void deleteProductById(@PathVariable Integer id) {

        this.productService.deleteProductById(id);
    }

    @GetMapping(value = "/getAllProduct")
    public List<Product> getAllProduct() {
        return this.productService.getAllProduct();
    }

    @PutMapping(value = "/updateProduct/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody Product product) {

        this.productService.updateProduct(id, product);
    }



}
