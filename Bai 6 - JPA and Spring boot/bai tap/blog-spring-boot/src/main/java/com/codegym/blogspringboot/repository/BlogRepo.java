package com.codegym.blogspringboot.repository;

import com.codegym.blogspringboot.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Integer> {
          Blog findById(int id);



}
