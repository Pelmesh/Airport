package com.example.airport.repos;

import com.example.airport.domein.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findAllById(Long id);
}
