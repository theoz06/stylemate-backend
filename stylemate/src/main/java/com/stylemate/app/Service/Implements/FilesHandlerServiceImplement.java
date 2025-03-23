package com.stylemate.app.Service.Implements;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import com.stylemate.app.Service.StorageService;
import com.stylemate.app.Utils.StorageProperties;

@Service
public class FilesHandlerServiceImplement implements StorageService {
    
    private final Path path;

    public FilesHandlerServiceImplement(StorageProperties properties){
        this.path = Paths.get(properties.getLocation());
    }

    @Override
    public String store(MultipartFile file) {
        try {
            if (file.isEmpty()){
                throw new RuntimeException("Failed to store empty file");
            }

            if (file.getSize() > 10 * 1024 * 1024){
                throw new RuntimeException("File size cannot exceed 10MB");
            }

            String fileType = file.getContentType();
            if (fileType == null || !fileType.startsWith("image/")) {
                throw new RuntimeException("Invalid file type");
            }

            String originalFileName = file.getOriginalFilename();
            String fileExstension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + fileExstension;

            Path uploadPath = this.path.resolve(
                Paths.get(newFileName))
                .normalize().toAbsolutePath();

            if (!uploadPath.getParent().equals(this.path.toAbsolutePath())) {
                throw new RuntimeException("Cannot store file outside current directory.");
            }

            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, uploadPath, StandardCopyOption.REPLACE_EXISTING);
            }

            return newFileName;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    @Override
    public Resource loadImage(String fileName){
        try {
            Path filePath = this.path.resolve(fileName).normalize().toAbsolutePath();
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                throw new RuntimeException("Could not read file"); 
            }

            return resource;

        } catch (MalformedURLException e) {
            throw new RuntimeException("Error loading file", e);
        }
    }

    @Override
    public void delete(String fileName){
        try {
            Path filePath = this.path.resolve(fileName).normalize().toAbsolutePath();
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error deleting file", e);
        }
    }

    @Override
    public void init(){
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }
}
