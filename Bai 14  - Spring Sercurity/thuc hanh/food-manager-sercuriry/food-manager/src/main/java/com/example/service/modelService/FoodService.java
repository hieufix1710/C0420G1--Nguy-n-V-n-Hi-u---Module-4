package com.example.service.modelService;

import com.example.entity.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    Page<Food> findAll(Pageable pageable, String search);
    List<Food> getAll();
    Food findById(Long id);
    Food findByName( String name);
}
