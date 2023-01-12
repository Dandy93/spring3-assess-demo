package com.assessment.assessdemo.models;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String loan_code;
    private int book_id;
    private int student_id;
    private int status;
    private Timestamp date_created;
    private Timestamp date_updated;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLoan_code() {
        return loan_code;
    }
    public void setLoan_code(String loan_code) {
        this.loan_code = loan_code;
    }
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Timestamp getDate_created() {
        return date_created;
    }
    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }
    public Timestamp getDate_updated() {
        return date_updated;
    }
    public void setDate_updated(Timestamp date_updated) {
        this.date_updated = date_updated;
    }
}
