package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    
}
