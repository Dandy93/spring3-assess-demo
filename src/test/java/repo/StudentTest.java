package repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import models.Student;
import repo.StudentRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StudentTest {
    @Autowired private StudentRepo studentRepo;

    @Test
    public void testGetAllStudent(){
        List<Student> lStudents = studentRepo.findAll();
        lStudents.forEach(System.out::println);
    }

    @Test
    public void testGetStudent(){
        String id = "SL0001";
        Student oStudent = studentRepo.getStudent(id);
        System.out.println(oStudent);
    }
}
