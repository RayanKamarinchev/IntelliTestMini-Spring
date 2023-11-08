package com.example.intellitest.models.dtos.users;

import java.util.List;

public class TeacherViewModel {
    private String FullName;
    private long Id;
    private String School;
    private String ImagePath;
    
    public String getFullName() {
        return FullName;
    }
    
    public void setFullName(String fullName) {
        FullName = fullName;
    }
    
    public long getId() {
        return Id;
    }
    
    public void setId(long id) {
        Id = id;
    }
    
    public String getSchool() {
        return School;
    }
    
    public void setSchool(String school) {
        School = school;
    }
    
    public String getImagePath() {
        return ImagePath;
    }
    
    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
}
