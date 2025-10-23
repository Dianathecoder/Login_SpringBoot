package com.example.Login_RA_02;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = {"model"})
@RestController
public class LoginRa02Application {

	public static void main(String[] args) {
		SpringApplication.run(LoginRa02Application.class, args);
	}
	 
	
 }

	

