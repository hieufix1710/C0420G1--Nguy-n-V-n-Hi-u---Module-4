package com.example.blogresful.repository;

import com.example.blogresful.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo  extends JpaRepository<Blog,Long> {
}
