package com.codegym.furamaspringboot.service;

import com.codegym.furamaspringboot.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ICustomerType {
    List<CustomerType> findAllCustomerType();


}
