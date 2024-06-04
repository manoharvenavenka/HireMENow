package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import com.example.services.EmailService;

import org.springframework.boot.context.event.ApplicationReadyEvent;

@SpringBootApplication
public class HireMeNowApplication {
	@Autowired
	EmailService senderservice;
	
	public static void main(String[] args) {
		SpringApplication.run(HireMeNowApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
	   // senderservice.sendEmail("manoharvenavenka01@gmail.com", "Subject: Mail Testing", "Body: Hai Yooo Whats Up");
		
		
	}
}
