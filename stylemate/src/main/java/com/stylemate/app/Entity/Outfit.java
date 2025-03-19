package com.stylemate.app.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "outfits")
public class Outfit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name is required")
    private String name;

    private Boolean isFavorite;

    @NotNull(message = "Category is required")
    @ManyToOne
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;

    @NotNull(message = "Color is required")
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @NotNull(message = "Material is required")
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @NotNull(message = "Pattern is required")
    @ManyToOne
    @JoinColumn(name = "pattern_id")
    private Pattern pattern;

    @NotNull(message = "Occasion is required")
    @ManyToMany
    @JoinTable(
        name = "outfit_occasion",
        joinColumns = @JoinColumn(name = "outfit_id"),
        inverseJoinColumns = @JoinColumn(name = "occasion_id")
    )
    private List<Occasion> occasions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
