package com.example.bloguseajax.controller;

import com.example.bloguseajax.model.Blog;
import com.example.bloguseajax.service.BlogSer;
import com.example.bloguseajax.service.CategorySer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private BlogSer blogSer;


    @Autowired
    private CategorySer categorySer;

    @GetMapping("/blogs")
    public ModelAndView getAll(@PageableDefault (3) Pageable pageable, @RequestParam (value = "search",defaultValue = "")String search){
        ModelAndView modelAndView = new ModelAndView("list-blog");
        modelAndView.addObject("blogs",this.blogSer.findAll(pageable, search));
        modelAndView.addObject("search",search);
        return modelAndView;
    }





//    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Page<Blog> searchBlog(@RequestBody String search,Pageable pageable) {
//        System.out.println(search);
//        return blogSer.findAll(pageable,search);
//    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView=new ModelAndView("create-form");
        modelAndView.addObject("categories",categorySer.findAll());
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @PostMapping (value = "/create")
    public ModelAndView create(@ModelAttribute ("blog") Blog blog){
            this.blogSer.save(blog);
            return new ModelAndView("create-form","message","Created !");
    }



}
