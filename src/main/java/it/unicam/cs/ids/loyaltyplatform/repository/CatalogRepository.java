package it.unicam.cs.ids.loyaltyplatform.repository;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Catalog;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    Optional<Product> findByIdProduct(Integer idProduct);

}
