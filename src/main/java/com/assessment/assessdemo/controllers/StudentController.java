package com.assessment.assessdemo.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.assessment.assessdemo.models.Student;
import com.assessment.assessdemo.repo.StudentRepo;

@Controller
public class StudentController {

    @Autowired
    private StudentRepo oStudentRepo;

    @Autowired
    private Helper oHelper;

    public List<Student> checkAllStudentName(){
        return oStudentRepo.findAll();
    }

    public void insertNewStudent(Student oStudent){
        Timestamp date = oHelper.getCurrentDate();
        oStudent.setDate_created(date);
        oStudent.setDate_updated(date);
        oStudent.setStatus(1);
        oStudentRepo.save(oStudent);
    }

    public Student getStudent(Student oStudent){
        Student rStudent = oStudentRepo.getStudent(oStudent.getEmail());
        return rStudent;
    }
}