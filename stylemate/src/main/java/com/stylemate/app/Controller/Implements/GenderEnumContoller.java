package com.stylemate.app.Controller.Implements;

import main.java.com.stylemate.app.Utils.GenderEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("api/gender/list")
public class GenderEnumContoller {
    
    @GetMapping
    public List<String> getRoles(){
        return Arrays.stream(GenderEnum.values()).map(GenderEnum::getGender).collect(Collectors.toList());
    }
}
