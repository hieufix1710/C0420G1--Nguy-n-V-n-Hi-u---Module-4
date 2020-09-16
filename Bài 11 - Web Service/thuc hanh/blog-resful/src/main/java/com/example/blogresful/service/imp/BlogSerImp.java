package com.example.blogresful.service.imp;

import com.example.blogresful.model.Blog;
import com.example.blogresful.repository.BlogRepo;
import com.example.blogresful.service.BlogSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogSerImp implements BlogSer {

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, Blog blog) {

    }



    @Override
    public Blog findById(long id) {
        return null;
    }

    @Override
    public void save(Blog blog) {

    }
}
