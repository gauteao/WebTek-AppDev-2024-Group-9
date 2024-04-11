package no.ntnu.stayfinder.repository;

import no.ntnu.stayfinder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
