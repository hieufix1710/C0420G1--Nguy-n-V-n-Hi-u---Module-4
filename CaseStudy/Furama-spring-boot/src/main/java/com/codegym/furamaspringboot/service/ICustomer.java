package com.codegym.furamaspringboot.service;

import com.codegym.furamaspringboot.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomer {
    Page<Customer> findAllCustomer(Pageable pageable,String search);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
    Customer findById(Long id);

    List<Customer> findAll();

}
