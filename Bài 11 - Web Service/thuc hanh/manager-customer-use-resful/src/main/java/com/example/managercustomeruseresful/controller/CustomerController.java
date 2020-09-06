package com.example.managercustomeruseresful.controller;

import com.example.managercustomeruseresful.model.Customer;
import com.example.managercustomeruseresful.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
   // get all customers
    // data type return is response entity have List customers inside
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customers=customerService.findAll();
        if (customers.isEmpty()){
            return new  ResponseEntity<List<Customer>> (HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<Customer>> (customers,HttpStatus.OK);
    }

    // get single customer by id
    @GetMapping(value = "/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable ("id") Long id){
        System.out.println("Customer :"+customerService.findById(id));
        Customer customer=(Customer) customerService.findById(id);
        if (customer==null){
            System.out.println("This customer not have inside list");
            return new  ResponseEntity<Customer> (HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }


    // create a customer
    @PostMapping("/create-customer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer){
        System.out.println("Create new customer :"+customer.getLastName());
        customerService.save(customer);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // update customer
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
         customerService.save(customer);
         return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @DeleteMapping ("/customer/delete/{id}")
     public ResponseEntity<Customer> deleteCustomer(@PathVariable ("id") Long id){
          Customer customer=(Customer) customerService.findById(id);
          if (customer==null){
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          customerService.delete(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }
}
