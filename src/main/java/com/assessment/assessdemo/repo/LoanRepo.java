package com.assessment.assessdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment.assessdemo.models.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer>{

    @Query(value = " SELECT * FROM loan WHERE student_id = ?1 AND YEAR(date_created) = ?2 ", nativeQuery = true)
    public List<Loan> getLoansByStudentId(int studentId , int year);
    
}
