package com.assessment.assessdemo.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.assessment.assessdemo.models.Book;
import com.assessment.assessdemo.repo.BookRepo;
import com.assessment.assessdemo.service.BookService;
import com.assessment.assessdemo.service.Helper;
import com.assessment.assessdemo.service.LibStatus;

@Controller
public class BookController {
    
    @Autowired
    private BookRepo oBookRepo;

    @Autowired
    private Helper oHelper;
    
    @Autowired
    private BookService oBookService;

    public List<Book> getActiveBooks (){
        return oBookService.getActiveBooks();
    }

    public List<Book> getAllBooks (){
        return oBookService.getAllBooks();
    }

    public void insertNewBook(Book oBook){
        Timestamp date = oHelper.getCurrentDate();
        oBook.setDate_created(date);
        oBook.setDate_updated(date);
        oBook.setStatus(LibStatus.Pending.getStatus());
        oBookRepo.save(oBook);
    } 
}
