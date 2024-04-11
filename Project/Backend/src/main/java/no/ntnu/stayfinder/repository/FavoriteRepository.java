package no.ntnu.stayfinder.repository;

import no.ntnu.stayfinder.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
