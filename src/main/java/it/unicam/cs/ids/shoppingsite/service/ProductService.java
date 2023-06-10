package it.unicam.cs.ids.shoppingsite.service;

import it.unicam.cs.ids.shoppingsite.repository.ProductRepository;
import it.unicam.cs.ids.shoppingsite.shoppingservices.Product;
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
    public void deleteProduct(Product product) {

        this.productRepository.delete(product);
   }
}
