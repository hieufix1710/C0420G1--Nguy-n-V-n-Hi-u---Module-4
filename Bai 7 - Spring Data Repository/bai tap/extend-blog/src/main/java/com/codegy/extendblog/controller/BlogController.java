package com.codegy.extendblog.controller;

import com.codegy.extendblog.model.Blog;
import com.codegy.extendblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping ("/blogs")
    public String listBlog(Model model, @PageableDefault(2) Pageable pageable){
           model.addAttribute("blogs",this.blogService.findAllCategory(pageable));
           return "list";
    }
    @GetMapping ("/blogs/search")
    public String list( @PageableDefault(2) Pageable pageable,@RequestParam (value = "search",defaultValue = "") String search,Model model){
        Page<Blog> blogPage=blogService.searchByCategory(search,pageable);
        model.addAttribute("blogs",blogPage);
        model.addAttribute("search",search);
        return "list";
    }

    @GetMapping ("/blogs/create")
    public String createForm(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categorys",this.blogService.findAllCategory());
        return "create";
    }
    @PostMapping("/blogs/create")
    public ModelAndView create(@ModelAttribute ("blog") Blog blog){
        this.blogService.save(blog);
        return new ModelAndView("create","message","Create success !");
    }

    @GetMapping ("/blogs/delete/")
    public String delete (@RequestParam Long  id){
        this.blogService.delete(id);
            return "redirect:/blogs";
    }

    @GetMapping ("/blogs/category")
    public ModelAndView categoryManager(){
        return new ModelAndView("listCategory","categorys",this.blogService.findAllCategory());
    }

    @GetMapping ("/blogs/edit/")
    public ModelAndView editForm(@RequestParam Long id){
        return new ModelAndView("edit","blog",this.blogService.findById(id));
    }

    @PostMapping ("/blogs/update")
    public ModelAndView update(@ModelAttribute ("blog") Blog blog){
        this.blogService.save(blog);
        return new ModelAndView("edit","message","Update success !");
    }




}
