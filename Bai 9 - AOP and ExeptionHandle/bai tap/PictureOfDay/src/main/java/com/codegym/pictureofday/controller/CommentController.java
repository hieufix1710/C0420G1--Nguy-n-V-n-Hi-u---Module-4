package com.codegym.pictureofday.controller;

import com.codegym.pictureofday.model.Comment;
import com.codegym.pictureofday.service.CommentSer;
import com.codegym.pictureofday.service.SpamWordSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {
     @Autowired
     private CommentSer commentSer;
     @Autowired
     private SpamWordSer spamWordSer;
    @RequestMapping ("/comment")
    public ModelAndView view(){
       ModelAndView modelAndView= new ModelAndView("view");
       modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("totalComment",this.commentSer.countTotalLike());
       return modelAndView;
    }
    @PostMapping ("/comment/create")
    public ModelAndView create(@ModelAttribute ("comment") Comment comment) throws Exception{
         ModelAndView modelAndView= new ModelAndView("view");
         if (spamWordSer.checkSpam(comment)==true){
             commentSer.save(comment);
             modelAndView.addObject("message","Commented !");
             modelAndView.addObject("totalComment",this.commentSer.countTotalLike());
             return modelAndView;
         }

        modelAndView.addObject("message","this comment is not relevant !");
        modelAndView.addObject("totalComment",this.commentSer.countTotalLike());
        return modelAndView;

    }

    @ExceptionHandler(Exception.class)
    public ModelAndView redirectToPageError(){
        return new ModelAndView("error-page");
    }

    @GetMapping("/comments")
    public ModelAndView showComment(){
        List<Comment> commentList=this.commentSer.findAll();
        if (commentList.equals(null)){
            return new ModelAndView("view-comments","message","Have comment yet !");
        }
        return new ModelAndView("view-comments","comments",this.commentSer.findAll());
    }
}
