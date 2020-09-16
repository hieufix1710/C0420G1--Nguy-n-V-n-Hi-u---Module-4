package com.example.controller;

import java.security.Principal;
import java.util.List;


import com.example.entity.model.Blog;
import com.example.service.modelService.BlogService;
import com.example.service.modelService.CategoryService;
import com.example.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class MainController {


//
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "adminPage";
//    }
//
//   @GetMapping ("/login")
//    public String loginPage(Model model) {
//        return "loginPage";
//    }
//
//
    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
//
//    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//    public String userInfo(Model model, Principal principal) {
//
//        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "userInfoPage";
//    }
//
//    @RequestMapping(value = "/403", method = RequestMethod.GET)
    @GetMapping ("/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
   @Autowired
   private CategoryService categoryService;

   @Autowired
   private BlogService blogService;

    @GetMapping("/login")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/blogs")
    public String getAllBlogs(Pageable pageable, Model model, @RequestParam (value = "search",defaultValue = "")String search,Principal principal ){
         model.addAttribute("blogs",blogService.findAll(pageable,search));
         model.addAttribute("search",search);

//         Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "blogs";
    }

    @GetMapping ("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categories",categoryService.getAll());
        return "createForm";

    }
    @PostMapping ("/create")
    public String createNew(@ModelAttribute ("blog") Blog blog,Model model){
        this.blogService.save(blog);
        model.addAttribute("message","Created !");
        return "createForm";
    }

    @GetMapping ("/delete/")
    public String delete(@RequestParam ("id") Long id,Model model,Principal principal,Pageable pageable,@RequestParam (value = "search",defaultValue = "") String search){
        this.blogService.delete(id);
        model.addAttribute("message","Deleted !");
//         Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        model.addAttribute("blogs",blogService.findAll(pageable,search));
        model.addAttribute("search",search);


        return "blogs";
    }

    @GetMapping(value = {"/home","/"," "})
    public String welcomePage(){
        return "welcomePage";
    }

    @GetMapping ("/admin")
    public String adminPage(Principal principal,Model model){
        //         Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "adminPage";
    }
    @PostMapping(value = "/blog/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> searchBlog(@RequestBody String search) {
        return blogService.findAllByTitleContaining(search);
    }



}