package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    
    @Query(value = " SELECT * FROM student WHERE id = :id", nativeQuery = true)
    public Student getStudent(String id);
    
}
