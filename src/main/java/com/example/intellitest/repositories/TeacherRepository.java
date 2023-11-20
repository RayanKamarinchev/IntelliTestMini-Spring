package com.example.intellitest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.intellitest.models.entities.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findTopByUserId(Long userId);
    Optional<Teacher> getByUserId(Long userId);
}
