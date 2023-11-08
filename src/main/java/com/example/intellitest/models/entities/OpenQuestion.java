package com.example.intellitest.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "OpenQuestions")
public class OpenQuestion extends BaseEntity{
    @Column(nullable = false)
    private String question;
    
    @Column(nullable = false)
    private String answer;
    
    @Column(nullable = false)
    private Integer order;
    
    @Column(nullable = false)
    private Boolean IsDeleted;
    
    @ManyToOne
    private Test test;
    
    @OneToMany
    private List<OpenQuestionAnswer> answers;
    
    @Column(nullable = false)
    private Integer maxScore;
    
    @Column(nullable = false)
    private boolean isEquation;
    
    @Column
    private String ImagePath;
    
    public boolean isEquation() {
        return isEquation;
    }
    
    public OpenQuestion setEquation(boolean equation) {
        isEquation = equation;
        return this;
    }
    
    public String getImagePath() {
        return ImagePath;
    }
    
    public OpenQuestion setImagePath(String imagePath) {
        ImagePath = imagePath;
        return this;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
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
    
    public List<OpenQuestionAnswer> getAnswers() {
        return answers;
    }
    
    public void setAnswers(List<OpenQuestionAnswer> answers) {
        this.answers = answers;
    }
    
    public Integer getMaxScore() {
        return maxScore;
    }
    
    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }
}
