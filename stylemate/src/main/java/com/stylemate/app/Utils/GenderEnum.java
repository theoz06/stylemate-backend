package com.stylemate.app.Utils;


public enum GenderEnum {
    MAN("Man"),
    WOMAN("Woman");

    private final String gender;

    GenderEnum(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public static GenderEnum fromString(String gender){
        for (GenderEnum g : GenderEnum.values()){
            if (g.gender.equalsIgnoreCase(gender)){
                return g;
            }
        }
        throw new IllegalArgumentException("Role Not Found." + gender); 
    }
}
