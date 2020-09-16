package com.example.bloguseajax.repository;

import com.example.bloguseajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {

    @Query ("select c from Blog c where c.category.name like :name")
    Page<Blog> findAllByCategory(Pageable pageable,String name);
    @Query ("select c from Blog c")
    Page<Blog> findAll(Pageable pageable,String name);


}
