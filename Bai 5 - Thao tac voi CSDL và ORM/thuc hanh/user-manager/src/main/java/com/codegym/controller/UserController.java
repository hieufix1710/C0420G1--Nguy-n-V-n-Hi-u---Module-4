package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import com.codegym.service.imp.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService=new UserServiceImp();
    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("list","users",this.userService.findAll());
    }
    @GetMapping ("/create-user")
    public ModelAndView create(){
        return new ModelAndView("create","user",new User());
    }

    @PostMapping("/create-user")
    public ModelAndView create(@ModelAttribute("user")User user){
        this.userService.save(user);
        return showList();
    }
}
