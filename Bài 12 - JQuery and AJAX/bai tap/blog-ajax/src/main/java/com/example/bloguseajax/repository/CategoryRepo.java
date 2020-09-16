package com.example.bloguseajax.repository;

import com.example.bloguseajax.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepo extends JpaRepository<Category,Long> {

    @Query("select c from Category  c where  c.name like :name")
    Category findByName( String name);
}
