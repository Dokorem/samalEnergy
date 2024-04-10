package com.example.Samal_Energy.service;

import com.example.Samal_Energy.models.Mail;
import com.example.Samal_Energy.repositories.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailRepository mailRepository;

    public List<Mail> mailList() {
        List<Mail> list = mailRepository.findAll();
        Collections.reverse(list);
        return list;
    }

    public void saveMail(Mail mail) {
        mailRepository.save(mail);
    }

}
