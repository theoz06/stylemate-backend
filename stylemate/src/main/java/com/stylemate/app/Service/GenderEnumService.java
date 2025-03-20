package com.stylemate.app.Service;

public enum GenderEnumService {
    MALE("Male"), FEMALE("Female");

    private final String gender;

    GenderEnumService(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public static GenderEnumService fromString(String gender){
        for(GenderEnumService genderEnum : GenderEnumService.values()){
            if(genderEnum.gender.equalsIgnoreCase(gender)){
                return genderEnum;
            }
        }

        throw new IllegalArgumentException("Invalid Gender: " + gender);
    }
}
