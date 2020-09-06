package com.example.customvalidatephone.controller;

import com.example.customvalidatephone.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {

    @GetMapping ("/phone")
    public ModelAndView showForm (){
        return new ModelAndView("form","phone",new PhoneNumber());
    }

    @GetMapping ("/add")
    public ModelAndView checkValidate(@Valid @ModelAttribute ("phone") PhoneNumber phoneNumber, BindingResult bindingResult){
           if (bindingResult.hasErrors()){
               return new ModelAndView("form"); // or return for error page
           }
           return new ModelAndView("form","message","Ok !");
    }
}
