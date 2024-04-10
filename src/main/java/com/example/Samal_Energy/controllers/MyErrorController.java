package com.example.Samal_Energy.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Возвращаем имя вашей страницы с ошибкой
        return "home";
    }

    @GetMapping("/error")
    public String getErrorPath() {
        return "redirect:/";
    }

}
