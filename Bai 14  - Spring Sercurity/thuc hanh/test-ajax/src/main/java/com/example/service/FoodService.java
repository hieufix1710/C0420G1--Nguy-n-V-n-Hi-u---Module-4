package com.example.service;

import com.example.model.Food;


import java.util.List;

public interface FoodService {
    List<Food> findAll();
    void save(Food food);
    void deleteById(Long id);
    List<Food> findByName(String name);

}
