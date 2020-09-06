package com.codegym.furamaspringboot.repository;

import com.codegym.furamaspringboot.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query ("select c from Customer  c where c.name like :name")
    Page<Customer> showListCustomerBySearch(Pageable page, String name);

    @Query ("select c from Customer  c")
    Page<Customer> showListCustomer(Pageable page, String name);
}
