package com.example.intellitest.models.dtos.tests;

import com.example.intellitest.models.dtos.questions.ClosedQuestionViewModel;
import com.example.intellitest.models.dtos.questions.OpenQuestionViewModel;
import com.example.intellitest.models.entities.*;
import com.example.intellitest.models.enums.PublicityType;
import com.example.intellitest.models.enums.Subject;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.List;

public class TestViewModel {
    @NotNull
    @Size(min = 5, max = 30)
    private String name;
    
    @NotNull
    private Subject subject;
    @NotNull
    @Range(min = 1, max =12)
    private Integer grade;
    
    @NotNull
    @Size(max = 1000, min = 5)
    private String description;
    
    @NotNull
    private String school;
    
    @NotNull
    private Double averageScore;
    
    private List<OpenQuestion> openQuestions;
    
    private List<ClosedQuestion> closedQuestions;
    
    private Date createdOn;
    
    private Boolean isCreator;
    
    @NotNull
    private PublicityType publicityType;
    
    private Boolean isTestTaken;
    
    public String getName() {
        return name;
    }
    
    public TestViewModel setName(String name) {
        this.name = name;
        return this;
    }
    
    public Subject getSubject() {
        return subject;
    }
    
    public TestViewModel setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }
    
    public Integer getGrade() {
        return grade;
    }
    
    public TestViewModel setGrade(Integer grade) {
        this.grade = grade;
        return this;
    }
    
    public String getDescription() {
        return description;
    }
    
    public TestViewModel setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public String getSchool() {
        return school;
    }
    
    public TestViewModel setSchool(String school) {
        this.school = school;
        return this;
    }
    
    public Double getAverageScore() {
        return averageScore;
    }
    
    public TestViewModel setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
        return this;
    }
    
    public List<OpenQuestion> getOpenQuestions() {
        return openQuestions;
    }
    
    public TestViewModel setOpenQuestions(List<OpenQuestion> openQuestions) {
        this.openQuestions = openQuestions;
        return this;
    }
    
    public List<ClosedQuestion> getClosedQuestions() {
        return closedQuestions;
    }
    
    public TestViewModel setClosedQuestions(List<ClosedQuestion> closedQuestions) {
        this.closedQuestions = closedQuestions;
        return this;
    }
    
    public Date getCreatedOn() {
        return createdOn;
    }
    
    public TestViewModel setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }
    
    public Boolean getCreator() {
        return isCreator;
    }
    
    public TestViewModel setCreator(Boolean creator) {
        isCreator = creator;
        return this;
    }
    
    public PublicityType getPublicityType() {
        return publicityType;
    }
    
    public TestViewModel setPublicityType(PublicityType publicityType) {
        this.publicityType = publicityType;
        return this;
    }
    
    public Boolean getTestTaken() {
        return isTestTaken;
    }
    
    public TestViewModel setTestTaken(Boolean testTaken) {
        isTestTaken = testTaken;
        return this;
    }
}
