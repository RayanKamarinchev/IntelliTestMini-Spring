package com.example.intellitest.models.dtos.questions.closed;

import com.example.intellitest.models.dtos.questions.QuestionViewModel;

public class ClosedQuestionViewModel extends QuestionViewModel {
    public String[] PossibleAnswers;
    public boolean[] CorrectAnswers;
    public int MaxScore;
}
