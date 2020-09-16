package com.example.service;

import com.example.entity.Category;

import java.util.List;

public interface CategoryService {
    void save (Category category);
    Category findByName(String name);
    List<Category> findAll();
}
