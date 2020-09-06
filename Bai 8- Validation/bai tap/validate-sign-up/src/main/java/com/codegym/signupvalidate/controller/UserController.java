package com.codegym.signupvalidate.controller;

import com.codegym.signupvalidate.model.User;
import com.codegym.signupvalidate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping ("")
    public ModelAndView showForm(){
        return new ModelAndView("form-sign-up","user",new User());
    }
//    @PostMapping ("/create-new-user")
//    public ModelAndView createNewUser(@Validated @ModelAttribute ("user") User user, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return new ModelAndView("form-sign-up");
//        }
//        boolean check=this.userService.save(user);
//        if (check==false){
//             return new ModelAndView("form-sign-up","message","Email of number phone had used!");
//        }
//        return new ModelAndView("form-sign-up","message","Create success!");
//
//    }

    @PostMapping ("/create-new-user")
    public ModelAndView createNewUser(@Validated @ModelAttribute ("user") User user,BindingResult bindingResult){
          new User().validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("form-sign-up");
        }
        boolean check=this.userService.save(user);
        if (check==false){
             return new ModelAndView("form-sign-up","message","Email of number phone had used!");
        }
        return new ModelAndView("form-sign-up","message","Create success!");
    }
}
