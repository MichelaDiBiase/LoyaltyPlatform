package it.unicam.cs.ids.shoppingsite.repository;

import it.unicam.cs.ids.shoppingsite.shoppingservices.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
