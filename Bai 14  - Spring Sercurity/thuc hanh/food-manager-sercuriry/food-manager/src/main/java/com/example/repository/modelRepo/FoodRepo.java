package com.example.repository.modelRepo;

import com.example.entity.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food,Long> {

    @Query ("select c from Food  c where c.category.name like :search")
    Page<Food> findAllByCategory(Pageable pageable,String search);

    @Query ("select c from Food  c")
    Page<Food> findAll(Pageable pageable,String search);
}
