package com.example.service.imp;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySerImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void save(Category category) {
              categoryRepository.save(category);
    }

    @Override
    public Category findByName(String name) {
        Category category=categoryRepository.findByName(name);
        if (category==null) {
            return null;
        }
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
