package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Outfit;

public interface OutfitRepository extends JpaRepository<Outfit, Integer> {
    
}
