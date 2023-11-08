package com.example.intellitest.models.dtos.tests;

import com.example.intellitest.models.dtos.questions.closed.ClosedQuestionReviewViewModel;
import com.example.intellitest.models.dtos.questions.open.OpenQuestionReviewViewModel;
import com.example.intellitest.models.enums.QuestionType;

import java.util.List;

public class TestReviewViewModel {
    private List<ClosedQuestionReviewViewModel> ClosedQuestions;
    private List<OpenQuestionReviewViewModel> OpenQuestions;
    private List<QuestionType> QuestionsOrder;
    private double Score;
    
    public List<ClosedQuestionReviewViewModel> getClosedQuestions() {
        return ClosedQuestions;
    }
    
    public void setClosedQuestions(List<ClosedQuestionReviewViewModel> closedQuestions) {
        ClosedQuestions = closedQuestions;
    }
    
    public List<OpenQuestionReviewViewModel> getOpenQuestions() {
        return OpenQuestions;
    }
    
    public void setOpenQuestions(List<OpenQuestionReviewViewModel> openQuestions) {
        OpenQuestions = openQuestions;
    }
    
    public List<QuestionType> getQuestionsOrder() {
        return QuestionsOrder;
    }
    
    public void setQuestionsOrder(List<QuestionType> questionsOrder) {
        QuestionsOrder = questionsOrder;
    }
    
    public double getScore() {
        return Score;
    }
    
    public void setScore(double score) {
        Score = score;
    }
}
