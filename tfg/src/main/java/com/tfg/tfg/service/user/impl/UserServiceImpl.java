package com.tfg.tfg.service.user.impl;

import com.tfg.tfg.model.User;
import com.tfg.tfg.repository.UserRepository;
import com.tfg.tfg.service.user.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user;
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Transactional
    @Override
    public Optional<User> findByNameAndLastNames(String name, String lastNames) {
        Optional<User> user = userRepository.findByNameAndLastNames(name, lastNames);
        if (user.isPresent()) {
            return user;
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Transactional
    @Override
    public Optional<User> findByDni(String dni) {
        Optional<User> user = userRepository.findByDni(dni);
        if (user.isPresent()) {
            return user;
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Transactional
    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user;
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Transactional
    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setLastNames(user.getLastNames());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setTelephone(user.getTelephone());
            updatedUser.setRole(user.getRole());
            return userRepository.save(updatedUser);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
