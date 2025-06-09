package sda.serviceaggregatingevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
