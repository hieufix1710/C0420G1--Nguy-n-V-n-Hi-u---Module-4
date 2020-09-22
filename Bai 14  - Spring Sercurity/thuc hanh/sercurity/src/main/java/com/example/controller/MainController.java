package com.example.controller;

import java.security.Principal;


import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRegister;
//import com.example.entity.UserRole;
import com.example.entity.UserRole;
import com.example.service.RoleService;
import com.example.service.UserService;
import com.example.service.UserRegisterService;
import com.example.service.UserRoleService;
import com.example.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserService userService;



    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message","Do something here !");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model,@CookieValue ("userName") String userName) {
        model.addAttribute("username",userName);
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal, HttpServletResponse response) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        Cookie cookie=new Cookie("userName",principal.getName());
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("userName" , userName);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);
            String userName = principal.getName();

            model.addAttribute("userInfo", userInfo);
            model.addAttribute("userName" , userName);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }





    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user",new UserRegister());
        return "registerForm";
    }

    @PostMapping ("/register")
    public String register(@ModelAttribute ("user") UserRegister userRegister,Model model){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPassword = encoder.encode(userRegister.getUser().getEncrytedPassword());
        // tạo 1 app user lưu tài khoản
        User user =new User();
        user.setUserName(userRegister.getUser().getUserName());
        user.setEncrytedPassword(hashPassword);
        user.setEnabled(true);

        userService.save(user);


        // set quyen cho user
        Role role = roleService.findById((long)2);

        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleService.save(userRole);


        //set app user cho user details register
        userRegister.setUser(user);
        userRegisterService.save(userRegister);

        model.addAttribute("message","Ok !");
        return "registerForm";
    }


}