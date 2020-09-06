package com.codegym.furamaspringboot.service.imp;

import com.codegym.furamaspringboot.model.CustomerType;
import com.codegym.furamaspringboot.repository.CustomerTypeRepo;
import com.codegym.furamaspringboot.service.ICustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeImp implements ICustomerType {
    @Autowired
    private CustomerTypeRepo customerTypeRepo;
    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepo.findAll();
    }
}
