package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlanPoints;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import it.unicam.cs.ids.loyaltyplatform.repository.ProductRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CustomerService customerService;

    public ProductService(ProductRepository productRepository, CustomerService customerService) {

        this.productRepository = productRepository;
        this.customerService = customerService;
    }

    public Product getProductById(Integer id) {
        return this.productRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Product> getAllProduct() {

        return this.productRepository.findAll();
    }
    public Product addProduct(Product product) {
        if(this.productRepository. findByName(product.getName()).isPresent()) {
            throw new EntityExistsException("Name " + product.getName() + "it already exists");
        }

       return this.productRepository.save(product);
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

    public void redeemProduct(Integer id, Integer idCustomer) {
        if(this.customerService.getCustomerById(id).getRegistrations().parallelStream().anyMatch(x -> x.getLoyaltyPlan() instanceof LoyaltyPlanPoints && x.getLoyaltyPlan().getIdAgency().equals(getProductById(id).getIdAgency()))) {
            throw new EntityNotFoundException("Customer can not redeem this product");
        }
        //this.customerService.getCustomerById(idCustomer).subtractPoints(getProductById(id).getPoints());
    }
}
