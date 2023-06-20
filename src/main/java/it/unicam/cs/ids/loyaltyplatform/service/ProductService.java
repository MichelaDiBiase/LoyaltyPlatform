package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.repository.ProductRepository;
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
    public Product addProduct(Product product) {

       return this.productRepository.save(product);
    }
    public void deleteProduct(Integer id) {

        this.productRepository.findById(id).orElseThrow(NullPointerException::new);
   }

    public void updateProduct(Product product) {
        this.productRepository.deleteById(product.getId());
        addProduct(product);
    }
}
