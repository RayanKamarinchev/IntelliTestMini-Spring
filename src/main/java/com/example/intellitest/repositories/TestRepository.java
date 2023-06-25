package com.example.intellitest.repositories;

import com.example.intellitest.models.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    @Query(value = "select * from Test t where isDeleted = false and" +
            "(publicityType = 'Public' or " +
            "(teacherId != '' and publicityType = 'TeachersOnly'))",
            nativeQuery = true)
    public List<Test> getAllTests(Long teacherId);
}
