package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void  save(Customer c);
    void delete(int id);
    void edit(int id,Customer customer);
}
