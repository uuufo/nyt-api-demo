package dev.jlarsen.nytapidemo.repositories;

import dev.jlarsen.nytapidemo.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByRole(String role);
}
