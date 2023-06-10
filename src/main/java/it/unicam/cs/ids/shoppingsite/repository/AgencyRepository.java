package it.unicam.cs.ids.shoppingsite.repository;

import it.unicam.cs.ids.shoppingsite.entity.users.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {
}
