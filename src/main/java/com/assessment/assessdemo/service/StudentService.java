package com.assessment.assessdemo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.assessdemo.models.Student;
import com.assessment.assessdemo.repo.StudentRepo;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepo oStudentRepo;

    @Autowired
    private Helper oHelper;

    public List<Student> checkAllStudentName(){
        List<Student> lUsers = oStudentRepo.findAll();
        List<Student> rListUsers = lUsers.stream().filter(s -> s.getStatus() != LibStatus.Inactive.getStatus() || s.getStatus() != LibStatus.NonAvailable.getStatus()).toList();
        return rListUsers;
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

    public String removeStudent(int studentId){
        String result = "";
        try {
            oStudentRepo.deleteById(studentId);
            result = "success";
        } catch (Exception e) {
            result = "failed";
        }
        return result;
    }

}
