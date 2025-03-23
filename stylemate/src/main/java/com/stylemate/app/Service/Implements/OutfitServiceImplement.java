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
import com.stylemate.app.Entity.DTO.ResponseDTO.OutfitResponse;
import com.stylemate.app.Service.Implements.FilesHandlerServiceImplement;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OutfitServiceImplement {

    private final OutfitRepository outfitRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final OccasionRepository occasionRepository;
    private final MaterialRepository materialRepository;
    private final PatternRepository patternRepository;
    private final ColorRepository colorRepository;
    private final UserRepository userRepository;
    private final FilesHandlerServiceImplement filesHandlerService;
    

    public OutfitServiceImplement(OutfitRepository outfitRepository, 
                                SubCategoryRepository subCategoryRepository, 
                                OccasionRepository occasionRepository, 
                                MaterialRepository materialRepository, 
                                PatternRepository patternRepository, 
                                ColorRepository colorRepository,
                                UserRepository userRepository,
                                FilesHandlerServiceImplement filesHandlerService){
        
        this.outfitRepository = outfitRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.occasionRepository = occasionRepository;
        this.materialRepository = materialRepository;
        this.patternRepository = patternRepository;
        this.colorRepository = colorRepository;
        this.userRepository = userRepository;
        this.filesHandlerService = filesHandlerService;
    }
    
    public List<OutfitResponse> getAllOutFits() {
        List<Outfit> outfits = outfitRepository.findAll();

        List<OutfitResponse> responses = new ArrayList<>();
        for (Outfit outfit : outfits) {
            OutfitResponse response = new OutfitResponse();
            response.setId(outfit.getId());
            response.setName(outfit.getName());
            response.setIsFavorite(outfit.getIsFavorite());
            response.setSubCategory(outfit.getSubCategory().getDescription());
            response.setMaterial(outfit.getMaterial().getDescription());
            response.setPattern(outfit.getPattern().getDescription());
            response.setColor(outfit.getColor().getDescription());
            response.setUser(outfit.getUser().getId().toString());
            
            List<String> occasions = new ArrayList<>();
            for(Occasion occasion : outfit.getOccasions()){
                occasions.add(occasion.getDescription());
            }
            response.setOccasions(occasions);

            responses.add(response);
        }

        return responses;

    }
    
    public String create(OutfitCreateRequest request, MultipartFile image) {
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

        if (image != null && !image.isEmpty()){
                String fileName = filesHandlerService.store(image);
                outfit.setImage(fileName);
        }

        outfitRepository.save(outfit);
        return "Created Successfully";
    }

    public String update(Integer id, OutfitCreateRequest request, MultipartFile image){


            
            Outfit outfit = outfitRepository.findById(id).orElseThrow(()-> new RuntimeException("Outfit Not Found!"));

            User user = userRepository.findById(outfit.getUser().getId()).orElseThrow(()-> new RuntimeException("User Not Found!"));
            SubCategory subCategory = subCategoryRepository.findById(request.getSubCategoryId()).orElseThrow(()-> new RuntimeException("Category Not Found!"));
            Material material = materialRepository.findById(request.getMaterialId()).orElseThrow(()-> new RuntimeException("Material Not Found!"));
            Pattern pattern = patternRepository.findById(request.getPatternId()).orElseThrow(()-> new RuntimeException("Pattern Not Found!"));
            Color color = colorRepository.findById(request.getColorId()).orElseThrow(()-> new RuntimeException("Color Not Found!"));
            List<Occasion> occasions = occasionRepository.findAllById(request.getOccasionIds());

            outfit.setName(request.getName());
            outfit.setSubCategory(subCategory);
            outfit.setOccasions(occasions);
            outfit.setMaterial(material);
            outfit.setPattern(pattern);
            outfit.setColor(color);
            outfit.setIsFavorite(request.getIsFavorite());
            outfit.setUser(user);

            if(image != null && !image.isEmpty() && image.getOriginalFilename() != outfit.getImage()){
                String fileName = filesHandlerService.store(image);
                outfit.setImage(fileName);
            }

            outfitRepository.save(outfit);
            return "Updated Successfully";
    
    }

}