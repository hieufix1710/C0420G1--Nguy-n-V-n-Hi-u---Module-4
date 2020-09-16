package com.example.service.modelService.imp;

import com.example.entity.model.Blog;
import com.example.repository.modelRepo.BlogRepository;
import com.example.service.modelService.BlogService;
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
        return blogRepository.findAllByCategory(pageable, search);
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
            blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
            blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByCategory(Pageable pageable,String category) {
        return blogRepository.findAllByCategory(pageable,category);
    }

    @Override
    public List<Blog> findAllByTitleContaining(String name) {
        return blogRepository.findAllByTitleContaining(name);
    }
}
