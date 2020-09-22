package com.example.controller;

import java.security.Principal;


import com.example.service.modelSer.AppRoleService;
import com.example.service.modelSer.AppUserService;
import com.example.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Transactional
@Controller
public class MainController {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppRoleService appRoleService;



    @GetMapping(value = {"/", " "})
    public String welcomePage() {
        return "first-page";
    }

    @GetMapping("/furama-resort")
    public String homePage(Principal principal, Model model) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userName",principal.getName());
        //set user name display to homepage
        model.addAttribute("userInfo", userInfo);
        return "home-page";
    }

    @GetMapping("/login")
    public String loginForm(Model model,@CookieValue (value = "username",defaultValue = "") String setUser) {
        System.out.println(setUser);
        model.addAttribute("username",setUser);
        return "user/loginPage";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout successful !");
        return "user/logoutSuccessfulPage";
    }


    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "user/403Page";
    }

    @GetMapping("/user-info")
    public String showInfo(Principal principal, Model model, HttpServletResponse response) {
        //add cookie to response
        Cookie cookie=new Cookie("username",principal.getName());

        cookie.setMaxAge(60);
        response.addCookie(cookie);


        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "user/user-information";
    }









}