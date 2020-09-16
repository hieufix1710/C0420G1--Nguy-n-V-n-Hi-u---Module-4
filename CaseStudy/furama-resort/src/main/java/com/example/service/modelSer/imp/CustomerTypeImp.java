package com.example.service.modelSer.imp;


import com.example.entity.model.CustomerType;
import com.example.repository.modelRepo.CustomerTypeRepo;
import com.example.service.modelSer.ICustomerType;
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
