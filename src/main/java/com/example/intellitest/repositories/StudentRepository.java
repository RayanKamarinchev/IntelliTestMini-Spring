package com.example.intellitest.repositories;

import com.example.intellitest.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findTopByUserId(@Param("userId") Long userId);
    Optional<Student> getByUserId(@Param("userId") Long userId);
}
