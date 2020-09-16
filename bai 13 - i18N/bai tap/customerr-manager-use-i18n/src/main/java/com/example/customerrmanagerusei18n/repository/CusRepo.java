package com.example.customerrmanagerusei18n.repository;


import com.example.customerrmanagerusei18n.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CusRepo extends JpaRepository<Customer,Long> {
}
