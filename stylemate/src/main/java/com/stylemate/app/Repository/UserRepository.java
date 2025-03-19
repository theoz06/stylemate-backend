package com.stylemate.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    
}
