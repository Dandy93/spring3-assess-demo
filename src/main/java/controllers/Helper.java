package controllers;

import java.util.List;

public class Helper {
    
    public Integer countTotal(List<Integer> statuses){
        return statuses.stream().reduce(0,(a,b)->a+b);
    }
}
