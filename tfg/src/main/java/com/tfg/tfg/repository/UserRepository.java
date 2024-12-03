package com.tfg.tfg.repository;

import com.tfg.tfg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNameAndLastNames(String name, String lastNames);

    Optional<User> findByDni(String dni);

    Optional<User> findByEmail(String email);
}
