package com.codegym.pictureofday.controller;

import com.codegym.pictureofday.model.Comment;
import com.codegym.pictureofday.service.CommentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {
     @Autowired
     private CommentSer commentSer;
    @RequestMapping ("/comment")
    public ModelAndView view(){
        return new ModelAndView("view","comment",new Comment());
    }
    @PostMapping ("/comment/create")
    public ModelAndView create(@ModelAttribute ("comment") Comment comment){
         commentSer.save(comment);
         return new ModelAndView("view","message","Commented !");

    }
}
