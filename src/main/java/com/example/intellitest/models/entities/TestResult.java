package com.example.intellitest.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "TestResults")
public class TestResult extends BaseEntity{
    @ManyToOne
    private Test test;
    
    @ManyToOne
    private Student student;
    
    @Column(nullable = false)
    private Integer score;
    
    @Column(nullable = false)
    private Date takenOn;
    
    public Test getTest() {
        return test;
    }
    
    public void setTest(Test test) {
        this.test = test;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public Date getTakenOn() {
        return takenOn;
    }
    
    public void setTakenOn(Date takenOn) {
        this.takenOn = takenOn;
    }
}
