package com.example.intellitest.models.dtos.users;

import jakarta.validation.constraints.NotNull;

public class UserType {
    private boolean IsStudent;
    @NotNull
    private int Grade;
    @NotNull
    private String School;
    
    public boolean isStudent() {
        return IsStudent;
    }
    
    public void setStudent(boolean student) {
        IsStudent = student;
    }
    
    public int getGrade() {
        return Grade;
    }
    
    public void setGrade(int grade) {
        Grade = grade;
    }
    
    public String getSchool() {
        return School;
    }
    
    public void setSchool(String school) {
        School = school;
    }
}
