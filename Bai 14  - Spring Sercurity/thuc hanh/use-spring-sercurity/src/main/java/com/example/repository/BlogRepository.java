package com.example.repository;

import com.example.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog,Long> {

    @Query("select c from Blog c where c.category.name like :name")
    Page<Blog> findAllByCategory(Pageable pageable, String name);
    @Query ("select c from Blog c")
    Page<Blog> findAll(Pageable pageable,String name);
}
