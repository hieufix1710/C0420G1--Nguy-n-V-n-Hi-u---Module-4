package com.example.service.imp;

import com.example.model.Food;
import com.example.repository.FoodRepository;
import com.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImp implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public void save(Food food) {
             foodRepository.save(food);
    }

    @Override
    public void deleteById(Long id) {
        foodRepository.deleteById(id);
    }


    @Override
    public List<Food> findByName(String name) {
        String temp="%"+name+"%";
        List<Food> foodList=foodRepository.getAllByName(temp);
        if (foodList.isEmpty()){
            return null;
        }
        return foodList ;
    }
}
