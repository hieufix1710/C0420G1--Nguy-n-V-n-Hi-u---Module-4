package com.example.blogresful.service;

import com.example.blogresful.model.Blog;

import java.util.List;

public interface BlogSer {
    List<Blog> findAll();
    void deleteById(Long id);
    void update(Long id,Blog blog);
    Blog findById(long id);
    void save(Blog blog);
}
