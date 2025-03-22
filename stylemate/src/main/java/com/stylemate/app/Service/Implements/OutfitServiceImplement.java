package com.stylemate.app.Service.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylemate.app.Entity.Outfit;
import com.stylemate.app.Repository.OutfitRepository;
import com.stylemate.app.Repository.SubCategoryRepository;
import com.stylemate.app.Repository.OccasionRepository;
import com.stylemate.app.Repository.MaterialRepository;
import com.stylemate.app.Repository.PatternRepository;
import com.stylemate.app.Repository.ColorRepository;
import com.stylemate.app.Repository.UserRepository;
import com.stylemate.app.Entity.SubCategory;
import com.stylemate.app.Entity.Occasion;
import com.stylemate.app.Entity.Material;
import com.stylemate.app.Entity.Pattern;
import com.stylemate.app.Entity.Color;
import com.stylemate.app.Entity.User;
import com.stylemate.app.Entity.DTO.RequestDTO.OutfitCreateRequest;


import java.util.List;


@Service
public class OutfitServiceImplement {

    private final OutfitRepository outfitRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final OccasionRepository occasionRepository;
    private final MaterialRepository materialRepository;
    private final PatternRepository patternRepository;
    private final ColorRepository colorRepository;
    private final UserRepository userRepository;

    public OutfitServiceImplement(OutfitRepository outfitRepository, 
                                SubCategoryRepository subCategoryRepository, 
                                OccasionRepository occasionRepository, 
                                MaterialRepository materialRepository, 
                                PatternRepository patternRepository, 
                                ColorRepository colorRepository,
                                UserRepository userRepository){
        
        this.outfitRepository = outfitRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.occasionRepository = occasionRepository;
        this.materialRepository = materialRepository;
        this.patternRepository = patternRepository;
        this.colorRepository = colorRepository;
        this.userRepository = userRepository;
    }
    
    public List<Outfit> getAllOutFits() {
        return outfitRepository.findAll();
    }
    
    public String create(OutfitCreateRequest request) {
        Outfit outfit = new Outfit();

        User user = userRepository.findById(request.getUserId()).orElseThrow(()-> new RuntimeException("User Not Found!"));
        SubCategory subCategory = subCategoryRepository.findById(request.getSubCategoryId()).orElseThrow(()-> new RuntimeException("SubCategory Not Found!"));
        Material material = materialRepository.findById(request.getMaterialId()).orElseThrow(()-> new RuntimeException("Material Not Found!"));
        Pattern pattern = patternRepository.findById(request.getPatternId()).orElseThrow(()-> new RuntimeException("Pattern Not Found!"));
        Color color = colorRepository.findById(request.getColorId()).orElseThrow(()-> new RuntimeException("Color Not Found!"));

        List<Occasion> occasions = occasionRepository.findAllById(request.getOccasionIds());
        
        outfit.setSubCategory(subCategory);
        outfit.setOccasions(occasions);
        outfit.setMaterial(material);
        outfit.setPattern(pattern);
        outfit.setColor(color);
        outfit.setName(request.getName());
        outfit.setIsFavorite(request.getIsFavorite());
        outfit.setUser(user);
        

        outfitRepository.save(outfit);
        return "Created Successfully";
    }

}