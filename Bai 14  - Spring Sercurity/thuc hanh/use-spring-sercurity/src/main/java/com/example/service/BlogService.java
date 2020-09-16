package com.example.service;

import com.example.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable, String search);
    void save(Blog blog);
    List<Blog> getAll();
    void delete(Long id);

}
