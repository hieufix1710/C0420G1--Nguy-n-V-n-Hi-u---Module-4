package com.example.bloguseajax.service.imp;

import com.example.bloguseajax.model.Category;
import com.example.bloguseajax.repository.CategoryRepo;
import com.example.bloguseajax.service.CategorySer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySerImp implements CategorySer {

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public void save(Category category) {
        if (categoryRepo.findByName(category.getName()).equals(category.getName())){
            categoryRepo.saveAndFlush(category);
        }
           categoryRepo.save(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
