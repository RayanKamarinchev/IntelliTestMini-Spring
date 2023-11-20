package com.example.intellitest.services;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileService{
    
    Path path;
    
    public FileService() {
        path = Paths.get("src/main/resources/static/img");
    }
    
    public String saveFile(MultipartFile file) throws IOException {
        
        String fileName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        fileName = uuid + fileName;
        
        Path resolvePath = path;
        if (!file.isEmpty()) {
            resolvePath = path.resolve(fileName);
        }
        Files.copy(file.getInputStream(), resolvePath, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }
}