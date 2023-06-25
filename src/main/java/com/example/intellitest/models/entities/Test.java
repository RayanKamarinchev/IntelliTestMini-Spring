package com.example.intellitest.models.entities;

import com.example.intellitest.models.enums.PublicityType;
import com.example.intellitest.models.enums.Subject;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Tests")
public class Test extends BaseEntity {
   @Column(nullable = false)
   @Length(max = 30, min = 5)
    private String name;
   
   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
    private Subject subject;
   @Column(nullable = false)
   @Range(min = 0, max =12)
    private Integer grade;
    
   @Column(nullable = false)
    @Length(max = 1000, min = 5)
    private String description;
   
   @Column(nullable = false)
    private Integer time;
   
   @Column(nullable = false)
    private Date createdOn;
   
   @Column
    @OneToMany
    private List<OpenQuestion> openQuestions;
    
    @Column
    @OneToMany
    private List<ClosedQuestion> closedQuestions;
    
    @Column(nullable = false)
    private Boolean IsDeleted;
    
    @Column(nullable = false)
    @ManyToOne
    private Teacher creator;
    
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PublicityType publicityType;
    
    @Column(nullable = false)
    @OneToMany
    private List<TestLike> testLikes;
    
    @Column(nullable = false)
    @OneToMany
    private List<TestResult> testResults;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Subject getSubject() {
        return subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    public Integer getGrade() {
        return grade;
    }
    
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getTime() {
        return time;
    }
    
    public void setTime(Integer time) {
        this.time = time;
    }
    
    public Date getCreatedOn() {
        return createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    public List<OpenQuestion> getOpenQuestions() {
        return openQuestions;
    }
    
    public void setOpenQuestions(List<OpenQuestion> openQuestions) {
        this.openQuestions = openQuestions;
    }
    
    public List<ClosedQuestion> getClosedQuestions() {
        return closedQuestions;
    }
    
    public void setClosedQuestions(List<ClosedQuestion> closedQuestions) {
        this.closedQuestions = closedQuestions;
    }
    
    public Boolean getDeleted() {
        return IsDeleted;
    }
    
    public void setDeleted(Boolean deleted) {
        IsDeleted = deleted;
    }
    
    public Teacher getCreator() {
        return creator;
    }
    
    public void setCreator(Teacher creator) {
        this.creator = creator;
    }
    
    public PublicityType getPublicityType() {
        return publicityType;
    }
    
    public void setPublicityType(PublicityType publicityType) {
        this.publicityType = publicityType;
    }
    
    public List<TestLike> getTestLikes() {
        return testLikes;
    }
    
    public void setTestLikes(List<TestLike> testLikes) {
        this.testLikes = testLikes;
    }
    
    public List<TestResult> getTestResults() {
        return testResults;
    }
    
    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }
}
