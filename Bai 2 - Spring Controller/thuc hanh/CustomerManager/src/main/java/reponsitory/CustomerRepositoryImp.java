package reponsitory;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImp implements CustomerReponsitory {
   static Map<Integer,Customer> customerList=new HashMap<>();
    static {
        customerList.put(1,new Customer(1,"Hieu","hieu@gmail.com","DN"));
        customerList.put(2,new Customer(2,"Hai","thai@gmail.com","HN"));
        customerList.put(3,new Customer(3,"Huan","huan@gmail.com","DN"));
        customerList.put(4,new Customer(4,"Truong","truon@gmail.com","HP"));
        customerList.put(5,new Customer(5,"Tuan","tuan@gmail.com","QB"));
    }
    @Override
    public List<Customer> findAll() {
         return new ArrayList<Customer>(customerList.values());
    }

    @Override
    public void save(Customer c) {
         customerList.put(c.getId(),c);
    }

    @Override
    public void delete(int id) {
          customerList.remove(id);
    }

    @Override
    public void edit(int id, Customer customer) {
           customerList.get(id).setName(customer.getName());
           customerList.get(id).setEmail(customer.getEmail());
           customerList.get(id).setAddress(customer.getAddress());
    }
}
