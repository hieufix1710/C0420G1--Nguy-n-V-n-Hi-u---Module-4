package com.example.service.modelService.imp;

import com.example.entity.model.Category;
import com.example.repository.modelRepo.CategoryRepo;
import com.example.service.modelService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySerImp implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void save(Category category) {
categoryRepo.save(category);
    }
}
