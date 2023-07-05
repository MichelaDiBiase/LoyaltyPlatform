package it.unicam.cs.ids.loyaltyplatform.service;


import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import it.unicam.cs.ids.loyaltyplatform.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }

    public Product getProductById(Integer id) {
        return this.productRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Product> getAllProduct() {

        return this.productRepository.findAll();
    }
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }
    public void deleteProductById(Integer id) {
        if(productRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("The id(" + id + ") of the product to delete does not exist");
        }
        this.productRepository.deleteById(id);
   }

    public void updateProduct(Integer id, Product product) {
        Product p = getProductById(id);
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPoints(product.getPoints());
        this.productRepository.saveAndFlush(p);
    }

}
