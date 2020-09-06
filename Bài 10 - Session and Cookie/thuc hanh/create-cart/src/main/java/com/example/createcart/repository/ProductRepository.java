package com.example.createcart.repository;

import com.example.createcart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query ("select c from Product c where c.nameProduct like :search")
    Page<Product> findAllBySearch(Pageable pageable,String search);
    @Query ("select c from Product c")
    List<Product> findAll(Pageable pageable, String search);

    @Query ("select c from Product c where c.category.id=:id")
    List<Product> findAllByCategory(Long id);

}
