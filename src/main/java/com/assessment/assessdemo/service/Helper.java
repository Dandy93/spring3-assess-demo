package com.assessment.assessdemo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class Helper {
    
    public Integer countTotal(ArrayList<Integer> statuses){
        return statuses.stream().reduce(0,(a,b)->a+b);
    }

    public Timestamp getCurrentDate(){
        Timestamp oTimestamp = new Timestamp(new Date().getTime());
        return oTimestamp;
    }
}
