package com.assessment.assessdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.assessdemo.models.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer>{

    @Query(value = " SELECT * FROM loan WHERE student_id = :studentid AND YEAR(date_created) = :year AND status IN (:statuses)", nativeQuery = true)
    public List<Loan> getCreditsFromLoansByStudentId(@Param("studentid") int studentId , @Param("year") int year, @Param("statuses") List<Integer> statuses);

    @Query(value = " SELECT * FROM loan WHERE student_id = ?1 AND YEAR(date_created) = ?2 ", nativeQuery = true)
    public List<Loan> getLoansByStudentId(int studentId , int year);

    @Query(value = " SELECT * FROM loan WHERE YEAR(date_created) = ?1 ", nativeQuery = true)
    public List<Loan> getLoansByYearAndStatus(int year);
}
