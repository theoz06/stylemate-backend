package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
