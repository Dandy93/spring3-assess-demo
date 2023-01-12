package com.assessment.assessdemo.models;

import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int code;
    private Timestamp date_created;
    private Timestamp date_updated;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
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
