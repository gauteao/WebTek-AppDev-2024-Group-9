package no.ntnu.stayfinder.repository;

import no.ntnu.stayfinder.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository  extends JpaRepository<Price, Long> {
}
