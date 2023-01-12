package com.assessment.assessdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class } )
public class AssessDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessDemoApplication.class, args);
	}
}