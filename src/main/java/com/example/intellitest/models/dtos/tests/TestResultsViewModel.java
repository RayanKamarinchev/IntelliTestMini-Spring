package com.example.intellitest.models.dtos.tests;

import com.example.intellitest.models.enums.Mark;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class TestResultsViewModel {
    private Long TestId;
    private Date TakenOn;
    private String Title;
    private String Description;
    private int Grade;
    private Mark Mark;
    private Long StudentId;
    private double Score;
    
    public Long getTestId() {
        return TestId;
    }
    
    public void setTestId(Long testId) {
        TestId = testId;
    }
    
    public Date getTakenOn() {
        return TakenOn;
    }
    
    public void setTakenOn(Date takenOn) {
        TakenOn = takenOn;
    }
    
    public String getTitle() {
        return Title;
    }
    
    public void setTitle(String title) {
        Title = title;
    }
    
    public String getDescription() {
        return Description;
    }
    
    public void setDescription(String description) {
        Description = description;
    }
    
    public int getGrade() {
        return Grade;
    }
    
    public void setGrade(int grade) {
        Grade = grade;
    }
    
    public com.example.intellitest.models.enums.Mark getMark() {
        return Mark;
    }
    
    public void setMark(com.example.intellitest.models.enums.Mark mark) {
        Mark = mark;
    }
    
    public Long getStudentId() {
        return StudentId;
    }
    
    public void setStudentId(Long studentId) {
        StudentId = studentId;
    }
    
    public double getScore() {
        return Score;
    }
    
    public void setScore(double score) {
        Score = score;
    }
}
