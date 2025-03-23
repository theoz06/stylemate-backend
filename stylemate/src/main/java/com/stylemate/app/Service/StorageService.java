package com.stylemate.app.Service;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface StorageService {
    
    void init();

    String  store(MultipartFile file);

    Resource loadImage(String filename);

    void delete(String filename);

}
