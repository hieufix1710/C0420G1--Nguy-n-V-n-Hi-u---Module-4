package com.codegy.extendblog.service;

import com.codegy.extendblog.model.Blog;
import com.codegy.extendblog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAllCategory(Pageable pageable);
    Blog findById(Long  id);
    void update (Long id,Blog blog,String category);
    void delete(Long id);
    void save (Blog blog);
    List<Category> findAllCategory();
    Page<Blog> searchByCategory(String search,Pageable pageable);
    void createNewCategory(String name);
}
