package com.example.intellitest.models.dtos.questions;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class QuestionViewModel {
    @NotNull
    private String Text;
    private boolean IsDeleted;
    private Long Id;
    @NotNull
    private boolean IsEquation;
    private String ImagePath;
    private int Index;
    private MultipartFile Image;
    
    public String getText() {
        return Text;
    }
    
    public void setText(String text) {
        Text = text;
    }
    
    public boolean isDeleted() {
        return IsDeleted;
    }
    
    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }
    
    public Long getId() {
        return Id;
    }
    
    public void setId(Long id) {
        Id = id;
    }
    
    public boolean isEquation() {
        return IsEquation;
    }
    
    public void setEquation(boolean equation) {
        IsEquation = equation;
    }
    
    public String getImagePath() {
        return ImagePath;
    }
    
    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
    
    public int getIndex() {
        return Index;
    }
    
    public void setIndex(int index) {
        Index = index;
    }
    
    public MultipartFile getImage() {
        return Image;
    }
    
    public void setImage(MultipartFile image) {
        Image = image;
    }
}
