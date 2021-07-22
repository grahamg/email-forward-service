package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	 @Value("${email.username}")
	 private String username;
	 
	 @Value("${email.pwd}")
	 private String pwd;

	 @Autowired
	 private EmailConfig emailConfig;
	 
	public void sendEmail(){
    System.out.println("reading value from propertes file using @value annotation");
    System.out.println("username ="+ username);
    System.out.println("pwd ="+ pwd);
	}
	
}
