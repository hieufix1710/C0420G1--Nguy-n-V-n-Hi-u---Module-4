package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping ("/register")
    public String registerForm(Model model){
        model.addAttribute("message","This page is updating !");
        return "errorPage"; 
    }
}
