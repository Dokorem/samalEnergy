package com.example.Samal_Energy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }

    @GetMapping("/insights")
    public String insightsPage(Model model) {
        return "insights";
    }

}
