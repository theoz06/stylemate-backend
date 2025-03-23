package com.stylemate.app.Controller.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylemate.app.Entity.Color;
import com.stylemate.app.Repository.ColorRepository;


@RestController
@RequestMapping("api/color")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Color>> getAllColors(){
        List<Color> colors = colorRepository.findAll();
        return ResponseEntity.ok(colors);
    }

}