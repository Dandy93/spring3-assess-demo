package com.assessment.assessdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.assessment.assessdemo.models.Student;
import com.assessment.assessdemo.service.LoanService;
import com.assessment.assessdemo.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService oStudentService;
    
    @Autowired
    private LoanService oLoanService;

    public List<Student> checkAllStudentName(){
        return oStudentService.checkAllStudentName();
    }

    public void insertNewStudent(Student oStudent){
        oStudentService.insertNewStudent(oStudent);
    }

    public Student getStudent(Student oStudent){
        return oStudentService.getStudent(oStudent);
    }

    public int getDoneStudentLoanCredit(Student oStudent){
        int rCredit =  oLoanService.getStudentCreditFromLoan(oStudent);
        return rCredit;
    }
}