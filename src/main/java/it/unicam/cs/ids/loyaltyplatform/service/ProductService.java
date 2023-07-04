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
        if(productRepository.findAll().parallelStream().noneMatch(x -> x.getId().equals(id))) {
            throw new EntityNotFoundException("The id(" + id + ") of the product to delete does not exist");
        }
        this.productRepository.findById(id).orElseThrow(NullPointerException::new);
   }

    public void updateProduct(Product product) {
        this.productRepository.deleteById(product.getId());
        addProduct(product);
    }

}
