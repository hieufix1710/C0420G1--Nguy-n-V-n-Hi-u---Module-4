package com.example.bloguseajax.service.imp;

import com.example.bloguseajax.model.Blog;
import com.example.bloguseajax.repository.BlogRepo;
import com.example.bloguseajax.service.BlogSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogSerImp implements BlogSer {

    @Autowired
    private BlogRepo blogRepo;
    @Override
    public Page<Blog> findAll(Pageable pageable, String search) {
        if ("".equals(search)){
            return blogRepo.findAll(pageable,search);
        }
        return blogRepo.findAllByCategory(pageable, search);
    }

    @Override
    public void save(Blog blog) {
               blogRepo.save(blog);
    }
}
