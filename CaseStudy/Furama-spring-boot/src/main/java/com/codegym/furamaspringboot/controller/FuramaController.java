package com.codegym.furamaspringboot.controller;

import com.codegym.furamaspringboot.model.User;
import com.codegym.furamaspringboot.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/furama")
public class FuramaController {
    @Autowired
    private IUser iUser;
    @GetMapping ("/")
    public ModelAndView showFirstPage(){
        return new ModelAndView("first-page","user",new User());

    }
    @PostMapping ("/login")
    public ModelAndView login(@Validated @ModelAttribute ("user") User user){
        if (this.iUser.check(user)==true){
            return new ModelAndView("home-page");
        }else {
            return new ModelAndView("first-page","message","Username or password not true !");
        }
    }

    
    
}
