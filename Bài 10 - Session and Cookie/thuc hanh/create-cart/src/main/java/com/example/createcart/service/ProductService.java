package com.example.createcart.service;

import com.example.createcart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void delete(Long id);
    void update(long id,Product product);
    void save(Product product);
    List<Product> findAllPage(Pageable pageable,String search);
    Page<Product> findAllBySearch(Pageable pageable,String search);
    List<Product> findByCategory(Long id);
    Product findById(Long id);

}
