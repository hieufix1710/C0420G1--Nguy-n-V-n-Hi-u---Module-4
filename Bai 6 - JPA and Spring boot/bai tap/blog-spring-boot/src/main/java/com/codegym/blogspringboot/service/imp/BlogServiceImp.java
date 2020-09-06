package com.codegym.blogspringboot.service.imp;

import com.codegym.blogspringboot.model.Blog;
import com.codegym.blogspringboot.repository.BlogRepo;
import com.codegym.blogspringboot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void delete(int id) {
       blogRepo.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id);
    }

    @Override
    public void update(int id,Blog blog) {
        blogRepo.saveAndFlush(blog);
    }
}
