package com.example.Samal_Energy;

import com.example.Samal_Energy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SamalEnergyApplication {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SamalEnergyApplication.class, args);
	}



}
