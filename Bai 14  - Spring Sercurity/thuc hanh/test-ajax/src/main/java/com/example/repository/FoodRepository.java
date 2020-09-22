package com.example.repository;

import com.example.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {

    @Query ("select c from Food  c where  c.name like :name ")
    List<Food> getAllByName(String name);
}
