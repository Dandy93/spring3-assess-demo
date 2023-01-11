package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControllerApi {
    @GetMapping("/check")
    public String checkCredit(@RequestParam int id, @RequestParam int year){
        String returnMessage = "Hi";



        return returnMessage;
    }
}
