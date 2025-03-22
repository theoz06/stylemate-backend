package com.stylemate.app.Entity.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutfitCreateRequest {
    private String name;
    private Integer subCategoryId;
    private Integer colorId;
    private Integer materialId;
    private Integer patternId;
    private List<Integer> occasionIds;
    private Boolean isFavorite;
    private Integer userId;
}
