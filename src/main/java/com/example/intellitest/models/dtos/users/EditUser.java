package com.example.intellitest.models.dtos.users;

import com.example.intellitest.models.enums.UserPanel;
import org.springframework.web.multipart.MultipartFile;

public class EditUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isTeacher;
    private UserPanel userPanel;
    private MultipartFile image;
    private String imageUrl = "";
    private String school = "";
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isTeacher() {
        return isTeacher;
    }
    
    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }
    
    public UserPanel getUserPanel() {
        return userPanel;
    }
    
    public void setUserPanel(UserPanel userPanel) {
        this.userPanel = userPanel;
    }
    
    public MultipartFile getImage() {
        return image;
    }
    
    public void setImage(MultipartFile image) {
        this.image = image;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
}
