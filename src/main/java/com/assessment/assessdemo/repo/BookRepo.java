package com.assessment.assessdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.assessdemo.models.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

    @Query(value = " SELECT * FROM book ", nativeQuery = true)
    public List<Book> getListBooks();

    @Query(value = " SELECT * FROM book WHERE status NOT IN (:statuses) ", nativeQuery = true)
    public List<Book> getActiveBooks(@Param("statuses") List<Integer> statuses);
}
