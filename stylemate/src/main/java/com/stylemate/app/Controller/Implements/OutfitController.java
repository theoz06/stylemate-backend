package com.stylemate.app.Controller.Implements;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import com.stylemate.app.Entity.DTO.RequestDTO.OutfitCreateRequest;
import com.stylemate.app.Entity.DTO.ResponseDTO.OutfitResponse;

import lombok.RequiredArgsConstructor;

import com.stylemate.app.Service.Implements.OutfitServiceImplement;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/outfit")
public class OutfitController {

    private final OutfitServiceImplement outfitService;
    
    @GetMapping("/list")
    public ResponseEntity<List<OutfitResponse>> getAllOutFits() {
        List<OutfitResponse> responses = outfitService.getAllOutFits();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addOutfit(@RequestPart("data") OutfitCreateRequest request, @RequestPart("image") MultipartFile image){
        String response = outfitService.create(request, image);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOutfit(@PathVariable Integer id, @RequestPart("data") OutfitCreateRequest request, @RequestPart("image") MultipartFile image){
        try{
            String response = outfitService.update(id, request, image);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatus());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOutfit(@PathVariable Integer id){
        try{
            String response = outfitService.delete(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatus());
        }
        
    }
}
