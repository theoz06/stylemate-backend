package com.stylemate.app.Controller.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylemate.app.Entity.Material;
import com.stylemate.app.Repository.MaterialRepository;



@RestController
@RequestMapping("api/material")
public class MaterialController{

    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Material>> getAllMaterials() {
        List<Material> materials = materialRepository.findAll();
        return ResponseEntity.ok(materials);
    }
}