package com.stylemate.app.Entity.DTO.ResponseDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutfitResponse {
    private Integer id;
    private String name;
    private Boolean isFavorite;
    private String subCategory;
    private String color;
    private String material;
    private String pattern;
    private List<String> occasions;
    private String user;
}
