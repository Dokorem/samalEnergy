package com.example.Samal_Energy.controllers;

import com.example.Samal_Energy.models.Mail;
import com.example.Samal_Energy.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ContactsController {

    private final MailService mailService;

    @GetMapping("/contacts")
    public String contactsPage(Model model) {
        model.addAttribute("currentPath", "contacts");
        return "contacts";
    }

    @PostMapping("/contacts/post")
    public String getInfoFromUser(@RequestParam String firstName,
                                  @RequestParam String secondName,
                                  @RequestParam String email,
                                  @RequestParam String messageText){
        System.out.println("Fullname: "+ firstName+ " "+ secondName+ "\nEmail: "+ email + "\nMessage Text: "+ messageText);
        Mail mail = new Mail();
        mail.setFullName(firstName + " " + secondName);
        mail.setEmail(email);
        mail.setMessage(messageText);
        mailService.saveMail(mail);
        return "redirect:/";
    }


}
