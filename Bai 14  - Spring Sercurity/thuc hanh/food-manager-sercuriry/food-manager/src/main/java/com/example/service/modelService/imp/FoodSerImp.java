package com.example.service.modelService.imp;

import com.example.entity.model.Food;
import com.example.repository.modelRepo.FoodRepo;
import com.example.service.modelService.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodSerImp implements FoodService {
    @Autowired
    private FoodRepo foodRepo;
    @Override
    public Page<Food> findAll(Pageable pageable, String search) {
        if ("".equals(search)){
            return foodRepo.findAll(pageable,search);
        }
        String temp="%"+search+"%";
        return foodRepo.findAllByCategory(pageable, temp);
    }

    @Override
    public List<Food> getAll() {
        return null;
    }

    @Override
    public Food findById(Long id) {
        return null;
    }

    @Override
    public Food findByName(String name) {
        return null;
    }
}
