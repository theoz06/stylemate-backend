package com.stylemate.app.Utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
    
    private String location = "Images";

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }
}
