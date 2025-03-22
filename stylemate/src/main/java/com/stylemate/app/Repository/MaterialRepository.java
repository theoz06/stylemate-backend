package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Material;

import java.util.List;


public interface MaterialRepository extends JpaRepository<Material, Integer> {
    List<Material> findAll();
}
