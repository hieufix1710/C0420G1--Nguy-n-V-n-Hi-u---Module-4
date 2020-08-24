package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService = new CustomerServiceImp();

    @GetMapping("/hello")
    public ModelAndView index() {
        List<Customer> customerList = customerService.findAll();
        return new ModelAndView("index","customers",customerList);
    }
    @GetMapping("/customer/create")
    public ModelAndView create(){
        return new ModelAndView("create","customer",new Customer());
    }
    @PostMapping("/customer/save")
    public ModelAndView save(@ModelAttribute ("customer") Customer customer, RedirectAttributes redirectAttributes){
        customer.setId((int)(Math.random() * 10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return index();
    }
    @GetMapping ("/customer/edit")
    public ModelAndView edit(@RequestParam int id){
        Customer customer=this.customerService.findById(id);
        return new ModelAndView("edit","customer",customer);
    }

    @PostMapping ("/customer/update")
    public ModelAndView update(@ModelAttribute ("customer") Customer customer){
        this.customerService.update(customer.getId(),customer);
        return index();
    }
    @GetMapping ("/customer/delete")
    public ModelAndView delete(@RequestParam int id){
        this.customerService.remove(id);
        return index();
    }
    @GetMapping ("/customer/view")
    public ModelAndView view(@RequestParam int id){
        return new ModelAndView("view","customer",this.customerService.findById(id));

    }
}