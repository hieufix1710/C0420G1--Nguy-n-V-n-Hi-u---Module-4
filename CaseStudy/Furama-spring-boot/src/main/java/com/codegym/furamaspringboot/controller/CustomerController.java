package com.codegym.furamaspringboot.controller;

import com.codegym.furamaspringboot.model.Customer;
import com.codegym.furamaspringboot.service.ICustomer;
import com.codegym.furamaspringboot.service.ICustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/furama-resort")
public class CustomerController {
    @Autowired
    private ICustomer customerService;

    @Autowired
    private ICustomerType customerTypeService;


    @GetMapping("/show-list-customer")
    public ModelAndView showListCustomer(@PageableDefault(5) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {
        ModelAndView modelAndView = new ModelAndView("list-customer");
        modelAndView.addObject("customers", this.customerService.findAllCustomer(pageable, search));
        modelAndView.addObject("search", search);

        return modelAndView;
    }

    @GetMapping("/create-new-customer")
    public ModelAndView createCustomerForm() {
        ModelAndView modelAndView = new ModelAndView("create-customer-form");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes",this.customerTypeService.findAllCustomerType());
        return modelAndView;
    }

    @PostMapping ("/create-new-customer")
    public ModelAndView createNewCustomer(@Validated @ModelAttribute ("customer") Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("create-customer-form");
        }else {
            this.customerService.saveCustomer(customer);
            System.out.println(customer.toString());
            return new ModelAndView("create-customer-form","message","Create success !");
        }
    }

    @GetMapping ("/customer-view/")
    public ModelAndView viewCustomer(@RequestParam Long id){
        return new ModelAndView("viewCustomer","customer",this.customerService.findById(id));
    }

    @GetMapping("/customer-edit/")
    public ModelAndView editForm(@RequestParam Long id){
        ModelAndView modelAndView=new ModelAndView("edit-customer");
        modelAndView.addObject("customer",this.customerService.findById(id));
        modelAndView.addObject("customerTypes",this.customerTypeService.findAllCustomerType());
        return modelAndView;
    }
    @PostMapping ("/customer-update/")
    public ModelAndView updateCustomer(@ModelAttribute ("customer") Customer customer){
        this.customerService.saveCustomer(customer);
        return new ModelAndView("edit-customer","message","Update success !");
    }

    @GetMapping ("/customer-delete")
    public String deleteCustomer(@RequestParam Long id){
        this.customerService.deleteCustomer(id);
        return "redirect:/furama-resort/show-list-customer";
    }
}
