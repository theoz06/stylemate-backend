package com.stylemate.app.Controller.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylemate.app.Entity.SubCategory;
import com.stylemate.app.Repository.SubCategoryRepository;


@RestController
@RequestMapping("api/outfit-category")
public class CategoryController{

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @GetMapping("/list")
    public ResponseEntity<List<SubCategory>> getAllSubCategories() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        return ResponseEntity.ok(subCategories);
    }
}