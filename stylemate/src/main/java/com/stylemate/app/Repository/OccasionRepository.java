package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Occasion;

import java.util.List;



public interface OccasionRepository extends JpaRepository<Occasion, Integer> {
    List<Occasion> findAll();
}
