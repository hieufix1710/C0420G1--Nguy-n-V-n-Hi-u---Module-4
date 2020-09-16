package com.example.bloguseajax.service;

import com.example.bloguseajax.model.Category;

import java.util.List;

public interface CategorySer {
    void save (Category category);
    Category findByName(String name);
    List<Category> findAll();
}
