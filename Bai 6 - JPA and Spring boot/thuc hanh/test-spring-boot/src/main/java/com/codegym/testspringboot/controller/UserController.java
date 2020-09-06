package com.codegym.testspringboot.controller;


import com.codegym.testspringboot.model.User;
import com.codegym.testspringboot.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @GetMapping("/users")
    public ModelAndView showList(){
        return new ModelAndView("list","users",this.userServiceImp.findAll());
    }
    @GetMapping ("/create")
    public ModelAndView createForm(){
        return new ModelAndView("create","user",new User());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute ("user")User user){
        this.userServiceImp.save(user);
        return showList();
    }





}
