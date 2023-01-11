package service;

import java.util.List;

import models.Student;

public interface StudentService {
    List<Student> get();
    Student get(int id);
    void add(Student student);
    void remove(int id);
}
