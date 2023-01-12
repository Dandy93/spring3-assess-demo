package com.assessment.assessdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.assessdemo.models.Book;
import com.assessment.assessdemo.repo.BookRepo;

@Service
public class BookService {
    
    @Autowired
    private BookRepo oBookRepo;

    public List<Book> getActiveBooks(){
        ArrayList<Integer> statuses =  new ArrayList<>();
        statuses.add(LibStatus.Inactive.getStatus());
        statuses.add(LibStatus.Pending.getStatus());
        statuses.add(LibStatus.NonAvailable.getStatus());
        return oBookRepo.getActiveBooks(statuses);
    }

    public List<Book> getAllBooks(){
        return oBookRepo.findAll();
    }
}
