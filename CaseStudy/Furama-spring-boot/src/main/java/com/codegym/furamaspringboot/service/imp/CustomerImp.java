package com.codegym.furamaspringboot.service.imp;

import com.codegym.furamaspringboot.model.Customer;
import com.codegym.furamaspringboot.repository.CustomerRepo;
import com.codegym.furamaspringboot.service.ICustomer;
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
    public Page<Customer> findAllCustomer(Pageable pageable,String search) {
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
