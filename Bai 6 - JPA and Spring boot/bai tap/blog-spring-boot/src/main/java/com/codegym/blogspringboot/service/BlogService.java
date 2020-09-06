package com.codegym.blogspringboot.service;

import com.codegym.blogspringboot.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void save (Blog blog);
    void delete(int id);
    Blog findById(int id);
    void update (int id,Blog blog);
}
