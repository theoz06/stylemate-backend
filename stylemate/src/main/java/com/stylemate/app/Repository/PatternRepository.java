package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Pattern;

import java.util.List;



public interface PatternRepository extends JpaRepository<Pattern, Integer> {
    List<Pattern> findAll();
}
