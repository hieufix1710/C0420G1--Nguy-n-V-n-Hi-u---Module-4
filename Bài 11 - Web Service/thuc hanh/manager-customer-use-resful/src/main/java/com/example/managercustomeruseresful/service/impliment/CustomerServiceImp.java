package com.example.managercustomeruseresful.service.impliment;

import com.example.managercustomeruseresful.model.Customer;
import com.example.managercustomeruseresful.repository.CustomerRepo;
import com.example.managercustomeruseresful.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService<Customer> {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Customer model) {
         customerRepo.saveAndFlush(model);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void delete(Long id) {
        customerRepo.deleteById(id);
    }
}
