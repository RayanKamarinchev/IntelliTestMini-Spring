package com.example.intellitest.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ClsoedQuestions")
public class ClosedQuestion extends BaseEntity{
    @Column(nullable = false)
    private String text;
    
    @Column(nullable = false)
    private String answerIndexes;
    
    @Column(nullable = false)
    private String availableAnswers;
    
    @Column(nullable = false)
    private Integer order;
    
    @Column(nullable = false)
    private Boolean IsDeleted;
    
    @ManyToOne
    private Test test;
    
    @Column(nullable = false)
    private Integer maxScore;
    
    @OneToMany()
    private List<ClosedQuestionAnswer> closedQuestionAnswers;
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getAnswerIndexes() {
        return answerIndexes;
    }
    
    public void setAnswerIndexes(String answerIndexes) {
        this.answerIndexes = answerIndexes;
    }
    
    public String getAvailableAnswers() {
        return availableAnswers;
    }
    
    public void setAvailableAnswers(String availableAnswers) {
        this.availableAnswers = availableAnswers;
    }
    
    public Integer getOrder() {
        return order;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }
    
    public Boolean getDeleted() {
        return IsDeleted;
    }
    
    public void setDeleted(Boolean deleted) {
        IsDeleted = deleted;
    }
    
    public Test getTest() {
        return test;
    }
    
    public void setTest(Test test) {
        this.test = test;
    }
    
    public Integer getMaxScore() {
        return maxScore;
    }
    
    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }
    
    public List<ClosedQuestionAnswer> getClosedQuestionAnswers() {
        return closedQuestionAnswers;
    }
    
    public void setClosedQuestionAnswers(List<ClosedQuestionAnswer> closedQuestionAnswers) {
        this.closedQuestionAnswers = closedQuestionAnswers;
    }
}
