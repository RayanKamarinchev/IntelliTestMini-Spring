package com.example.intellitest.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Teachers")
public class Teacher extends BaseEntity {
    @OneToOne
    private UserEntity user;
    
    @Column(nullable = false)
    private String school;
    
    @OneToMany
    private List<Test> tests;
    
    public UserEntity getUser() {
        return user;
    }
    
    public void setUser(UserEntity user) {
        this.user = user;
    }
    
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    
    public List<Test> getTests() {
        return tests;
    }
    
    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
