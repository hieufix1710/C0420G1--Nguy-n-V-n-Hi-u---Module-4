package com.example.service.imp;

import com.example.entity.Blog;
import com.example.repository.BlogRepository;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogSerImp implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable, String search) {
        if ("".equals(search)){
            return blogRepository.findAll(pageable,search);
        }
        String temp="%"+search+"%";
        return blogRepository.findAll(pageable,temp);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}
