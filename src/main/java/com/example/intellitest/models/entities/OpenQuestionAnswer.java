package com.example.intellitest.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OpenQuestionAnswers")
public class OpenQuestionAnswer extends BaseEntity{
    @Column
    private String answer;
    
    @Column(nullable = false)
    @ManyToOne
    private OpenQuestion question;
    
    @ManyToOne
    @Column
    private Student student;
    
    @Column(nullable = false)
    private Integer points;
    
    @Column
    private String Explaination;
    
    public String getAnswer() {
        return answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public OpenQuestion getQuestion() {
        return question;
    }
    
    public void setQuestion(OpenQuestion question) {
        this.question = question;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Integer getPoints() {
        return points;
    }
    
    public void setPoints(Integer points) {
        this.points = points;
    }
    
    public String getExplaination() {
        return Explaination;
    }
    
    public void setExplaination(String explaination) {
        Explaination = explaination;
    }
}
