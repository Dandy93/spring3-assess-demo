package com.assessment.assessdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment.assessdemo.models.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    
    @Query(value = " SELECT * FROM student WHERE email = ?1 LIMIT 1", nativeQuery = true)
    public Student getStudent(String email);

    @Query(value = " SELECT * FROM student WHERE status = ?1", nativeQuery = true)
    public List<Student> getStudentCountByStatus(int status);    
}