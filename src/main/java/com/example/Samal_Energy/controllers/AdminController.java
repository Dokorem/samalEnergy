package com.example.Samal_Energy.controllers;

import com.example.Samal_Energy.models.Mail;
import com.example.Samal_Energy.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final MailService mailService;

    @GetMapping("/samalEnergyReg/tempSamalEnergyAdmin/samalEnergyAdminRegistration")
    public String adminRegistrationPage() {
        return "admin-registration";
    }

    @PostMapping("/samalEnergyReg/tempSamalEnergyAdmin/samalEnergyAdminRegistration")
    public String adminPostRegistration() {
        return "redirect:/samalEnergyReg/tempSamalEnergyAdmin/SamalEnergyAdminPage/news/add";
    }

    @GetMapping("/samalEnergyReg/tempSamalEnergyAdmin/SamalEnergyAdminPage")
    public String adminPage() {
        return "news-add";
    }

    @GetMapping("/samalEnergyReg/tempSamalEnergyAdmin/SamalEnergyAdminPage/mails")
    public String mailPage(Model model) {
        model.addAttribute("mails", mailService.mailList());
        return "mails-list";
    }

}
