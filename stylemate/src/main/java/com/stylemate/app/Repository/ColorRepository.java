package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    
}
