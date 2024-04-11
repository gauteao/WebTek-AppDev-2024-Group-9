package no.ntnu.stayfinder.repository;

import no.ntnu.stayfinder.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
