package it.unicam.cs.ids.shoppingsite.repository;

import it.unicam.cs.ids.shoppingsite.entity.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
