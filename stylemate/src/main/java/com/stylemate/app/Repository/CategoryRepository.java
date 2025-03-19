package com.stylemate.app.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.stylemate.app.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
