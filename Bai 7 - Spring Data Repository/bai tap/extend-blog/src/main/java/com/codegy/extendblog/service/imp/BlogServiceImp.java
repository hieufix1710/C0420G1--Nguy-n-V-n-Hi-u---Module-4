package com.codegy.extendblog.service.imp;

import com.codegy.extendblog.model.Blog;
import com.codegy.extendblog.model.Category;
import com.codegy.extendblog.repository.BlogRepo;
import com.codegy.extendblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepo blogRepo;

    @Override
    public Page<Blog> findAllCategory(Pageable pageable) {
        return blogRepo.findAll(pageable);

    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Blog blog,String category) {
        blogRepo.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepo.deleteById(id);

    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public List<Category> findAllCategory() {
        return blogRepo.findAllCategory();
    }

    @Override
    public Page<Blog> searchByCategory(String search, Pageable pageable) {
        return blogRepo.searchByCategory(search, pageable);
    }

    @Override
    public void createNewCategory(String name) {


    }
}
