package com.example.intellitest.models.dtos.questions.open;

import java.util.List;

public class OpenQuestionStatsViewModel {
    private String Text;
    private List<String> StudentAnswers;
    
    public String getText() {
        return Text;
    }
    
    public void setText(String text) {
        Text = text;
    }
    
    public List<String> getStudentAnswers() {
        return StudentAnswers;
    }
    
    public void setStudentAnswers(List<String> studentAnswers) {
        StudentAnswers = studentAnswers;
    }
}
