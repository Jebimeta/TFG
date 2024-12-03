package com.tfg.tfg.service.user;

import com.tfg.tfg.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByNameAndLastNames(String name, String lastNames);

    Optional<User> findByDni(String dni);

    Optional<User> findByEmail(String email);

    User save(User user);

    User update(User user);

    void delete(Long id);
}
