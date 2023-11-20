package com.example.intellitest.models.dtos.users;

import com.example.intellitest.models.enums.UserPanel;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class EditUser {
    @Size(min = 3, max = 20)
    private String firstName;
    @Size(min = 3, max = 20)
    private String lastName;
    private String email;
    private String password;
    private boolean isTeacher;
    private boolean isStudent;
    private UserPanel userPanel;
    private MultipartFile image;
    private String imagePath;
    @Size(min = 3, max = 50)
    private String school = "";
    private Long userId;
    private String imageFolderPath;
    
    public boolean isTeacher() {
        return isTeacher;
    }
    
    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getImageFolderPath() {
        return imageFolderPath;
    }
    
    public void setImageFolderPath(String imageFolderPath) {
        this.imageFolderPath = imageFolderPath;
    }
    
    public boolean getIsStudent() {
        return isStudent;
    }
    
    public void setIsStudent(boolean student) {
        isStudent = student;
    }
    
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
    
    public boolean getIsTeacher() {
        return isTeacher;
    }
    
    public void setIsTeacher(boolean teacher) {
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
    
    public String getImagePath() {
        return imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
}
