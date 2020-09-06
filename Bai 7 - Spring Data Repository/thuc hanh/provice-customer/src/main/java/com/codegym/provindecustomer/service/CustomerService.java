package com.codegym.provindecustomer.service;

import com.codegym.provindecustomer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer>findAll();
    void update(Long id, Customer customer);
    void delete(Long id);
    void save(Customer customer);
    Customer findById(Long id);
    Page<Customer> findAll(Pageable pageable);
}
