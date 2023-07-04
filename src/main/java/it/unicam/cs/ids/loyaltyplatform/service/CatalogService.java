package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import it.unicam.cs.ids.loyaltyplatform.repository.CatalogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;
    private final ProductService productService;

    public CatalogService(CatalogRepository catalogRepository, ProductService productService) {
        this.catalogRepository = catalogRepository;
        this.productService = productService;
    }

    public void addProductToCatalog(Integer idProduct) {
        this.catalogRepository.save(this.productService.getProductById(idProduct));
    }

    public void deleteProductFromCatalog(Integer idProduct) {
        this.catalogRepository.deleteById(this.productService.getProductById(idProduct).getId());

    }


    public void updateProductFromCatalog(Product product) {
        Product p = this.productService.getProductById(product.getId());
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        this.catalogRepository.saveAndFlush(p);
    }

    public Product getProductFromCatalogByIdProduct(Integer idProduct) {
        return this.catalogRepository.findById(idProduct).orElseThrow(() -> new EntityNotFoundException("The id(" + idProduct + ") does not correspond to any Product"));

    }
}