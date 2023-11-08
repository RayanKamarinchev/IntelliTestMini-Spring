package com.example.intellitest.models.dtos.tests;

import com.example.intellitest.models.dtos.questions.closed.ClosedQuestionViewModel;
import com.example.intellitest.models.dtos.questions.open.OpenQuestionViewModel;
import com.example.intellitest.models.enums.QuestionType;

import java.util.List;

public class TestSubmitViewModel {
    private List<OpenQuestionViewModel> OpenQuestions;
    private List<ClosedQuestionViewModel> ClosedQuestions;
    private List<QuestionType> QuestionOrder;
    private String Title;
    private int Time;
    private long Id;
    
    public List<OpenQuestionViewModel> getOpenQuestions() {
        return OpenQuestions;
    }
    
    public void setOpenQuestions(List<OpenQuestionViewModel> openQuestions) {
        OpenQuestions = openQuestions;
    }
    
    public List<ClosedQuestionViewModel> getClosedQuestions() {
        return ClosedQuestions;
    }
    
    public void setClosedQuestions(List<ClosedQuestionViewModel> closedQuestions) {
        ClosedQuestions = closedQuestions;
    }
    
    public List<QuestionType> getQuestionOrder() {
        return QuestionOrder;
    }
    
    public void setQuestionOrder(List<QuestionType> questionOrder) {
        QuestionOrder = questionOrder;
    }
    
    public String getTitle() {
        return Title;
    }
    
    public void setTitle(String title) {
        Title = title;
    }
    
    public int getTime() {
        return Time;
    }
    
    public void setTime(int time) {
        Time = time;
    }
    
    public long getId() {
        return Id;
    }
    
    public void setId(long id) {
        Id = id;
    }
}
