package com.example.bloguseajax.service;

import com.example.bloguseajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogSer {

    Page<Blog> findAll(Pageable pageable,String search);
    void save(Blog blog);


}
