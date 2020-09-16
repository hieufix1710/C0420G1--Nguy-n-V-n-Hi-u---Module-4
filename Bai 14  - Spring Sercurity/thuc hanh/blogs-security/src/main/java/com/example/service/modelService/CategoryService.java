package com.example.service.modelService;

import com.example.entity.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category findById(Long id);
}
