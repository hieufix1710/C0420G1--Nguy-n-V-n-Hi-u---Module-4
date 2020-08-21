package reponsitory;

import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface CustomerReponsitory {
   List<Customer> findAll();
   void  save(Customer c);
   void delete(int id);
   void edit(int id,Customer customer);
}
