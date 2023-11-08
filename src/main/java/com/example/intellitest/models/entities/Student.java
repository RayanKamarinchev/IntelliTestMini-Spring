package com.example.intellitest.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Students")
public class Student extends BaseEntity{
    @OneToOne
    private UserEntity user;
    
    @Column(nullable = false)
    private String school;
    
    @OneToMany
    private List<TestResult> testResults;
    
    @OneToMany
    private List<OpenQuestionAnswer> openQuestionAnswers;
    
    @OneToMany
    private List<ClosedQuestionAnswer> closedQuestionAnswers;
    
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
    
    public List<TestResult> getTestResults() {
        return testResults;
    }
    
    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }
    
    public List<OpenQuestionAnswer> getOpenQuestionAnswers() {
        return openQuestionAnswers;
    }
    
    public void setOpenQuestionAnswers(List<OpenQuestionAnswer> openQuestionAnswers) {
        this.openQuestionAnswers = openQuestionAnswers;
    }
    
    public List<ClosedQuestionAnswer> getClosedQuestionAnswers() {
        return closedQuestionAnswers;
    }
    
    public void setClosedQuestionAnswers(List<ClosedQuestionAnswer> closedQuestionAnswers) {
        this.closedQuestionAnswers = closedQuestionAnswers;
    }
}
