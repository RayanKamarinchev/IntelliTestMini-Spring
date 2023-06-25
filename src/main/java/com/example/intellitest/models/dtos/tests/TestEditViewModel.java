package com.example.intellitest.models.dtos.tests;

import com.example.intellitest.models.dtos.questions.ClosedQuestionViewModel;
import com.example.intellitest.models.dtos.questions.OpenQuestionViewModel;
import com.example.intellitest.models.enums.PublicityType;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TestEditViewModel {
    @NotNull
    private PublicityType publicityType;
    
    private List<OpenQuestionViewModel> openQeustions;
    private List<ClosedQuestionViewModel> closedQeustions;
    
    @NotNull
    private String title;
    @NotNull
    private String description;
    
    public PublicityType getPublicityType() {
        return publicityType;
    }
    
    public void setPublicityType(PublicityType publicityType) {
        this.publicityType = publicityType;
    }
    
    public List<OpenQuestionViewModel> getOpenQeustions() {
        return openQeustions;
    }
    
    public void setOpenQeustions(List<OpenQuestionViewModel> openQeustions) {
        this.openQeustions = openQeustions;
    }
    
    public List<ClosedQuestionViewModel> getClosedQeustions() {
        return closedQeustions;
    }
    
    public void setClosedQeustions(List<ClosedQuestionViewModel> closedQeustions) {
        this.closedQeustions = closedQeustions;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
