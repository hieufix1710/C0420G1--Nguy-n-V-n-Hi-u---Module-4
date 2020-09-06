package com.ckodegym.validatesinginform.controller;

import com.ckodegym.validatesinginform.model.User;
import com.ckodegym.validatesinginform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @Autowired
    private UserService userService;

    @GetMapping ("/users")
    public ModelAndView showForm(){
        return new ModelAndView("index","user",new User());
    }
    @PostMapping ("/login")
    public ModelAndView login (@Validated @ModelAttribute ("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("index");
        }else {
            return new ModelAndView("result");
        }
    }

}
