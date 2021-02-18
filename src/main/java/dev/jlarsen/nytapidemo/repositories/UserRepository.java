package dev.jlarsen.nytapidemo.repositories;

import dev.jlarsen.nytapidemo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
