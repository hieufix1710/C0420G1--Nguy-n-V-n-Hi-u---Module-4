package com.example.service.modelService;

import com.example.entity.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable, String search);
    List<Blog> getAll();
    void save(Blog blog);
    void delete(Long id);
    Page<Blog> findByCategory(Pageable pageable,String category);
    List<Blog> findAllByTitleContaining(String name);

}
