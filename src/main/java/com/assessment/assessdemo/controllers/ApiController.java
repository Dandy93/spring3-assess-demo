package com.assessment.assessdemo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import com.assessment.assessdemo.models.Book;
import com.assessment.assessdemo.models.LoanResult;
import com.assessment.assessdemo.models.Student;

@Controller
public class ApiController {

    @Autowired
    private StudentController oStudentController;

    @Autowired
    private BookController oBookController;

    @Autowired
    private LoanController oLoanController;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/logout")
    public String signOut(){
        return "studentviews/index";
    }

    @PostMapping("/logout")
    public String postSignOut(){
        return "/index";
    }
    
    @GetMapping("/userhome")
    public String userHomePage(Model oModel){
        List<Student> listUsers = oStudentController.checkAllStudentName();
        oModel.addAttribute("listUsers", listUsers);
        return "studentviews/index";
    }

    @GetMapping("/login")
    public String studentLoginForm(Model oModel) {
        oModel.addAttribute("student", new Student());
        return "studentviews/userlogin";
    }

    @PostMapping("/postlogin")
    public String studentPostLogin(Student oStudent){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(oStudent.getPass());
        oStudent.setPass(encodedPassword);
        Student rStudent = oStudentController.getStudent(oStudent);
        if(rStudent == null){
            return "index";
        }
        return "redirect:/loanshome";
    }

    @GetMapping("/register")
    public String studentRegisterForm(Model oModel){
        oModel.addAttribute("student", new Student());
        return "studentviews/usercheck";
    }

    @PostMapping("/postregister")
    public String studentPostRegister(Student oStudent){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(oStudent.getPass());
        oStudent.setPass(encodedPassword);
        oStudentController.insertNewStudent(oStudent);
        return "studentviews/usersuccessregister";
    }

    @GetMapping("/userhome/active")
    public String studentGetActiveStudent(Model oModel) {
        List<Student> listUsers = oStudentController.checkAllStudentName();
        List<Student> rListUsers = listUsers.stream().filter(s -> s.getStatus() == 1).toList();
        oModel.addAttribute("listUsers", rListUsers);
        return "studentviews/index";
    }

    @GetMapping("/bookhome")
    public String bookHomePage(Model oModel){
        List<Book> lBooks = oBookController.getAllBooks();
        oModel.addAttribute("lBooks", lBooks);
        return "bookviews/index";
    }

    @GetMapping("/loanshome")
    public String loansHomePage(Model oModel){
        List<LoanResult> lLoans = oLoanController.getAllLoanList();
        oModel.addAttribute("lLoans", lLoans);
        return "loanviews/index";
    }
}