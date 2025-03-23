package com.stylemate.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Color;

import java.util.List;


public interface ColorRepository extends JpaRepository<Color, Integer> {
    List<Color> findAll();
}
