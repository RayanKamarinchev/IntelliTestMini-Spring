package com.example.intellitest.services;

import com.example.intellitest.models.dtos.tests.TestViewModel;
import com.example.intellitest.models.entities.Test;
import com.example.intellitest.models.entities.TestResult;
import com.example.intellitest.repositories.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TestService {
    private final TestRepository testRepository;
    
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
    
    public List<TestViewModel> getAllTests(Long teacherId, Long studentId){
        return testRepository
                .getAllTests(teacherId)
                .stream()
                .map(t -> map(t, studentId))
                .toList();
    }
    
    private TestViewModel map(Test t, Long studentId) {
        return new TestViewModel()
                .setAverageScore(Math.round(
                        t.getTestResults()
                         .stream()
                         .mapToInt(TestResult::getScore)
                         .average().orElse(0) * 100.0) / 100.0)
                .setDescription(t.getDescription())
                .setGrade(t.getGrade())
                .setCreator(t.getCreator()
                             .getTests()
                             .stream()
                        .anyMatch(tt -> Objects.equals(tt.getId(), t.getId())))
                .setName(t.getName())
                .setCreatedOn(t.getCreatedOn())
                .setClosedQuestions(t.getClosedQuestions())
                .setOpenQuestions(t.getOpenQuestions())
                .setSubject(t.getSubject())
                .setPublicityType(t.getPublicityType())
                .setSchool(t.getCreator().getSchool())
                .setTestTaken(t.getTestResults()
                               .stream()
                               .anyMatch(r -> Objects.equals(r.getStudent().getId(), studentId)));
    }
}
