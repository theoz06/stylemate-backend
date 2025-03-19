package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Pattern;


public interface PatternRepository extends JpaRepository<Pattern, Integer> {
    
}
