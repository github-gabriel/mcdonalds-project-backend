package de.gabriel.mcdonaldsproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.product = ?1")
    Optional<Order> findOrderByProducts(String product);

}
