package com.example.intellitest.models.dtos.questions.open;

public class OpenQuestionReviewViewModel extends OpenQuestionViewModel {
    private String CorrectAnswer;
    private Double Score;
    private String Explanation;
    
    public String getCorrectAnswer() {
        return CorrectAnswer;
    }
    
    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
    
    public Double getScore() {
        return Score;
    }
    
    public void setScore(Double score) {
        Score = score;
    }
    
    public String getExplanation() {
        return Explanation;
    }
    
    public void setExplanation(String explanation) {
        Explanation = explanation;
    }
}
