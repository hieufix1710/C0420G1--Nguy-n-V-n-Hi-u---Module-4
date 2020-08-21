package service;

import model.Customer;
import reponsitory.CustomerReponsitory;
import reponsitory.CustomerRepositoryImp;

import java.util.List;

public class CustomerServiceImp implements CustomerService {
    private CustomerReponsitory customerReponsitory=new CustomerRepositoryImp();
    @Override
    public List<Customer> findAll() {
        return customerReponsitory.findAll();
    }

    @Override
    public void save(Customer c) {
 customerReponsitory.save(c);
    }

    @Override
    public void delete(int id) {
 customerReponsitory.delete(id);
    }

    @Override
    public void edit(int id, Customer customer) {
          customerReponsitory.edit(id,customer);
    }
}
