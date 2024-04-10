package com.example.Samal_Energy.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleResourceNotFoundException() {
        return "error-404"; // Название вашего шаблона для 404 страницы
    }

}
