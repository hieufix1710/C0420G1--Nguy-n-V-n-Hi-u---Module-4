package com.example.validateformsignup.controller;

import com.example.validateformsignup.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    @GetMapping ("/login")
    public ModelAndView showForm(){
        return new ModelAndView("form","user",new User());
    }
    @PostMapping("/login")
    public ModelAndView login(@Validated @ModelAttribute ("user") User user, BindingResult bindingResult){
        new User().validate(user, bindingResult);   // must have this line to file config readable file validate .....
             if (bindingResult.hasFieldErrors()){
                 return new ModelAndView("form");
             }
        return new ModelAndView("form","message","Login success !");
    }
}
