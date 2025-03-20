package com.stylemate.app.Controller;

import java.util.Arrays;

import com.stylemate.app.Service.GenderEnumService;

@RestController
@RequestMapping("api/gender/list")
public class GenderEnumController {

    @GetMapping
    public List<GenderEnum> getAllGenders() {
        return Arrays.stream(GenderEnumService.values())
                .collect(Collectors.toList());
    }
}
