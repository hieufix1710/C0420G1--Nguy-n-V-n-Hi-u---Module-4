package com.example.repository.modelRepo;

import com.example.entity.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {

    @Query ("select c from Blog  c where c.category.name like  :search")
    Page<Blog> findAllByCategory(Pageable pageable,String search);

    @Query ("select c from Blog  c" )
    Page<Blog> findAll(Pageable pageable,String search);

    List<Blog> findAllByTitleContaining(String name);
}
