package com.example.createcart.service.imp;

import com.example.createcart.model.Product;
import com.example.createcart.repository.ProductRepository;
import com.example.createcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
          productRepository.deleteById(id);
    }

    @Override
    public void update(long id, Product product) {
         productRepository.saveAndFlush(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllPage(Pageable pageable,String search) {
        return productRepository.findAll(pageable,search);
    }

    @Override
    public Page<Product> findAllBySearch(Pageable pageable, String search) {
        return productRepository.findAllBySearch(pageable,search);
    }

    @Override
    public List<Product> findByCategory(Long id) {
        return productRepository.findAllByCategory(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
