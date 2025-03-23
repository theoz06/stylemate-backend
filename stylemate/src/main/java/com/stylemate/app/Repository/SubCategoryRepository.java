package com.stylemate.app.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stylemate.app.Entity.SubCategory;

import java.util.List;


public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    @Query(value = "SELECT * FROM sub_categories", nativeQuery = true)
    List<SubCategory> findAll();
}
