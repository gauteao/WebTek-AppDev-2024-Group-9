package no.ntnu.stayfinder.repository;

import no.ntnu.stayfinder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByHotelIdAndCheckInLessThanEqualAndCheckOutGreaterThanEqual(Long hotelId, LocalDate checkOut, LocalDate checkIn);
}
