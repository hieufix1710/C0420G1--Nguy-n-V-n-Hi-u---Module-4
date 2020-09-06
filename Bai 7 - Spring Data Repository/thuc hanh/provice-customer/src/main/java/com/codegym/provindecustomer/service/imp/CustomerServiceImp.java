package com.codegym.provindecustomer.service.imp;

import com.codegym.provindecustomer.model.Customer;
import com.codegym.provindecustomer.repository.CustomerRepo;
import com.codegym.provindecustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void update(Long id, Customer customer) {
          customerRepo.save(customer);
    }

    @Override
    public void delete(Long id) {
            customerRepo.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
           customerRepo.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }
}
