package com.assessment.assessdemo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.assessment.assessdemo.models.Loan;
import com.assessment.assessdemo.models.LoanResult;
import com.assessment.assessdemo.models.Student;
import com.assessment.assessdemo.repo.LoanRepo;
import com.assessment.assessdemo.service.LoanService;

@Controller
public class LoanController {

    @Autowired
    private LoanService oLoanService;

    @Autowired
    private LoanRepo oRepo;

    public List<LoanResult> getAllLoanList(){
        List<Loan> lLoans = oRepo.findAll();
        return oLoanService.populateLoanResultView(lLoans);
    }

    public List<LoanResult> getLoanList(Student oStudent){
        List<Loan> lLoans = oLoanService.getStudentLoans(oStudent);
        return oLoanService.populateLoanResultView(lLoans);
    }

    public int getStudentCredit(Student oStudent) {
        return oLoanService.getStudentCreditFromLoan(oStudent);
    }

    
}
