package com.stylemate.app.Controller.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylemate.app.Entity.Pattern;
import com.stylemate.app.Repository.PatternRepository;

import java.util.List;



@RestController
@RequestMapping("api/pattern")
public class PatternController{

    @Autowired
    private PatternRepository patternRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Pattern>> getPatterns(){
        List<Pattern> patterns = patternRepository.findAll();
        return new ResponseEntity<>(patterns, HttpStatus.OK);
    }
}