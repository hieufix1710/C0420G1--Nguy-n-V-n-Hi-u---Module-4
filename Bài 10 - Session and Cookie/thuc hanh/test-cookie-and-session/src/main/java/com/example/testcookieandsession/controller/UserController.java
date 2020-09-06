package com.example.testcookieandsession.controller;

import com.example.testcookieandsession.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes ("user")
public class UserController {


    @ModelAttribute ("user")
    public User setUser(){
        return new User();
    }

    @GetMapping ("/login")
    public ModelAndView login(){
          return new ModelAndView("login","user",new User());
    }

    @PostMapping ("/login")
    public ModelAndView saveAcc(@ModelAttribute ("user") User user,HttpServletResponse response, HttpServletRequest request){
        Cookie cookie=new Cookie("user",user.getName());
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return new ModelAndView("login","message","Success !");
    }

    @GetMapping("/")
    public ModelAndView showAcc(@CookieValue ("user") String user, HttpServletResponse response, HttpServletRequest request){
        Cookie cookie=new Cookie("user",user);
        response.addCookie(cookie);
        return new ModelAndView("show","user",cookie.getValue());
    }
}
