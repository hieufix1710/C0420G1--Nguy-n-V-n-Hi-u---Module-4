package com.example.service.modelSer.imp;


import com.example.entity.model.Customer;
import com.example.repository.modelRepo.CustomerRepo;
import com.example.service.modelSer.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerImp implements ICustomer {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String search) {
        if ("".equals(search)){
            return customerRepo.showListCustomer(pageable,search);
        }
        else {
            String temp= "%"+search+"%";
            return customerRepo.showListCustomerBySearch(pageable,temp);
        }

    }

    @Override
    public void saveCustomer(Customer customer) {
           customerRepo.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
      customerRepo.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
