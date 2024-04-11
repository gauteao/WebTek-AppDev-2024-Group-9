package no.ntnu.stayfinder.repository;

import no.ntnu.stayfinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
