package com.example.intellitest.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ClsoedQuestionsAnswers")
public class ClosedQuestionAnswer extends BaseEntity{
    @Column
    private String answerIndexes;
    
    @Column(nullable = false)
    @ManyToOne
    private ClosedQuestion closedQuestion;
    
    @Column(nullable = false)
    @ManyToOne
    private Student student;
    
    @Column(nullable = false)
    private Integer points;
    
    @Column
    private String Explaination;
    
    public String getAnswerIndexes() {
        return answerIndexes;
    }
    
    public void setAnswerIndexes(String answerIndexes) {
        this.answerIndexes = answerIndexes;
    }
    
    public ClosedQuestion getClosedQuestion() {
        return closedQuestion;
    }
    
    public void setClosedQuestion(ClosedQuestion closedQuestion) {
        this.closedQuestion = closedQuestion;
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
