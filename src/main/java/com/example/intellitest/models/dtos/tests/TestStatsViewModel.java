package com.example.intellitest.models.dtos.tests;

import com.example.intellitest.models.dtos.questions.closed.ClosedQuestionStatsViewModel;
import com.example.intellitest.models.dtos.questions.open.OpenQuestionStatsViewModel;
import com.example.intellitest.models.enums.QuestionType;

import java.util.List;

public class TestStatsViewModel {
    private List<ClosedQuestionStatsViewModel> ClosedQuestions;
    private List<OpenQuestionStatsViewModel> OpenQuestions;
    private List<QuestionType> QuestionsOrder;
    private double AverageScore;
    private int Examiners;
    
    public List<ClosedQuestionStatsViewModel> getClosedQuestions() {
        return ClosedQuestions;
    }
    
    public void setClosedQuestions(List<ClosedQuestionStatsViewModel> closedQuestions) {
        ClosedQuestions = closedQuestions;
    }
    
    public List<OpenQuestionStatsViewModel> getOpenQuestions() {
        return OpenQuestions;
    }
    
    public void setOpenQuestions(List<OpenQuestionStatsViewModel> openQuestions) {
        OpenQuestions = openQuestions;
    }
    
    public List<QuestionType> getQuestionsOrder() {
        return QuestionsOrder;
    }
    
    public void setQuestionsOrder(List<QuestionType> questionsOrder) {
        QuestionsOrder = questionsOrder;
    }
    
    public double getAverageScore() {
        return AverageScore;
    }
    
    public void setAverageScore(double averageScore) {
        AverageScore = averageScore;
    }
    
    public int getExaminers() {
        return Examiners;
    }
    
    public void setExaminers(int examiners) {
        Examiners = examiners;
    }
}
