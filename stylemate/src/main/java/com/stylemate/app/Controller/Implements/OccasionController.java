package com.stylemate.app.Controller.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylemate.app.Entity.Occasion;
import com.stylemate.app.Repository.OccasionRepository;

import java.util.List;



@RestController
@RequestMapping("api/occasion")
public class OccasionController{

    @Autowired
    private OccasionRepository occasionRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Occasion>> getOccasions() {
        List<Occasion> occasions = occasionRepository.findAll();
        return new ResponseEntity<>(occasions, HttpStatus.OK);
    }
}