package com.stylemate.app.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.stylemate.app.Service.GenderEnumService;

@RestController
@RequestMapping("api/gender")
public class GenderEnumController {

    @GetMapping("/list")
    public List<GenderEnum> getAllGenders() {
        return Arrays.stream(GenderEnumService.values())
                .collect(Collectors.toList());
    }
}
