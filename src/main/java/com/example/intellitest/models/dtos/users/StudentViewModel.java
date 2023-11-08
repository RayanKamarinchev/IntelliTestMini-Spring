package com.example.intellitest.models.dtos.users;

import java.util.List;

public class StudentViewModel {
    private String Name;
    private long Id;
    private String Email;
    private String ImagePath;
    private List<Double> TestResults;
    
    public String getName() {
        return Name;
    }
    
    public void setName(String name) {
        Name = name;
    }
    
    public long getId() {
        return Id;
    }
    
    public void setId(long id) {
        Id = id;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String email) {
        Email = email;
    }
    
    public String getPicture() {
        return ImagePath;
    }
    
    public void setPicture(String picture) {
        ImagePath = picture;
    }
    
    public List<Double> getTestResults() {
        return TestResults;
    }
    
    public void setTestResults(List<Double> testResults) {
        TestResults = testResults;
    }
}
