package com.example.blogresful.controller;

import com.example.blogresful.model.Blog;
import com.example.blogresful.service.BlogSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogSer blogSer;


    // get all
    @GetMapping ("/blogs")
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> blogList=this.blogSer.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    // save new blog
    @PostMapping ("/create")
    public ResponseEntity<Void> saveNew(@RequestBody Blog blog){
        this.blogSer.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    //edit blog
    @PutMapping ("/update")
    public ResponseEntity<Void> editBlog(@RequestParam ("id") Long id,@RequestBody Blog blog){
        this.blogSer.update(id,blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // delete blog
    @DeleteMapping ("/delete")
    public ResponseEntity<Void> delete(@RequestParam ("id") long id){
        this.blogSer.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
