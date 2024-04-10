package com.example.Samal_Energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String firstName, String secondName, String email, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vlabimirlysenko@gmail.com");
        message.setTo("vlabimirlysenko@gmail.com");
        message.setSubject("Site user question");
        message.setText(String.format("Fullname: %s %s \n" +
                "Email of sender: %s \n" +
                "Text of the message: %s",
                firstName, secondName, email, text));

        mailSender.send(message);

    }

}
