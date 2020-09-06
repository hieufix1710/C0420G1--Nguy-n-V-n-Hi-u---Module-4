package com.codegy.extendblog.repository;

import com.codegy.extendblog.model.Blog;

import com.codegy.extendblog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {
       @Query ("select c from Blog c order by c.dateStart")
       List<Blog> sortByDayStart();

       @Query ("select c from  Category  c ")
       List<Category> findAllCategory();

       @Query ("select c from Blog  c join Category u on u.id = c.category.id where c.category.name like :name")
       Page<Blog> searchByCategory(String name, Pageable p);



}
