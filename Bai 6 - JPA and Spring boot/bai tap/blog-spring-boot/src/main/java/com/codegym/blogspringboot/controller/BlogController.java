package com.codegym.blogspringboot.controller;

import com.codegym.blogspringboot.model.Blog;
import com.codegym.blogspringboot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogs")
    public ModelAndView showList() {
        return new ModelAndView("list", "blogs", this.blogService.findAll());
    }

    @GetMapping("/blogs/create")
    public ModelAndView createForm() {
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/blogs/create")
    public ModelAndView create(@ModelAttribute("blog") Blog blog) {
        this.blogService.save(blog);
        return showList();
    }

    @GetMapping("/blogs/read/")
    public ModelAndView read(@RequestParam int id) {
        return new ModelAndView("read", "blog", this.blogService.findById(id));
    }

    @GetMapping("/blogs/edit/")
    public ModelAndView editFrom(@RequestParam int id) {
        return new ModelAndView("edit", "blog", this.blogService.findById(id));
    }

    @PostMapping("/blogs/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog, @RequestParam int id) {
        this.blogService.update(id, blog);
        return new ModelAndView("edit", "message", "Update success !");
    }


    @GetMapping("/blogs/delete/")
    public ModelAndView delete(@RequestParam int id) {
        this.blogService.delete(id);
        return showList();
    }
}
