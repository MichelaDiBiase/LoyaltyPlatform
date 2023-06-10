package it.unicam.cs.ids.shoppingsite.repository;

import it.unicam.cs.ids.shoppingsite.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductRepository, Integer> {
}
