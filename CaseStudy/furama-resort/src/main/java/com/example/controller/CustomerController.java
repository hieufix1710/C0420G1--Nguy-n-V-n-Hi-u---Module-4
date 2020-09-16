package com.example.controller;

import com.example.entity.model.Customer;
import com.example.service.modelSer.ICustomer;
import com.example.service.modelSer.ICustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/admin")
public class CustomerController {
    @Autowired
    private ICustomer customerService;

    @Autowired
    private ICustomerType customerTypeService;


    @GetMapping("/show-list-customer")
    public String showListCustomer(@PageableDefault(5) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search, Model model) {
        model.addAttribute("customers", this.customerService.findAllCustomer(pageable, search));
        model.addAttribute("search", search);
        if (customerService.findAllCustomer(pageable, search).isEmpty()){
            model.addAttribute("message","Not fount this value !");
        }
        return "customer/list-customer";
    }

    @GetMapping("/create-new-customer")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes",this.customerTypeService.findAllCustomerType());
        return "customer/create-customer-form";
    }

    @PostMapping("/create-new-customer")
    public String createNewCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "customer/create-customer-form";
        }
            this.customerService.saveCustomer(customer);
            System.out.println(customer.toString());
            model.addAttribute("message","Create success !");
            return  "customer/create-customer-form";
    }

    @GetMapping ("/customer-view/")
    public String viewCustomer(@RequestParam Long id,Model model){
        model.addAttribute("customer",this.customerService.findById(id));
        return "customer/viewCustomer";
    }

    @GetMapping("/customer-edit/")
    public String editForm(@RequestParam Long id,Model model){

        model.addAttribute("customer",this.customerService.findById(id));
        model.addAttribute("customerTypes",this.customerTypeService.findAllCustomerType());
        return "customer/edit-customer";
    }
    @PostMapping ("/customer-update/")
    public String updateCustomer(@ModelAttribute ("customer") Customer customer,Model model){
        model.addAttribute("message","Update success !");
        this.customerService.saveCustomer(customer);

        return "customer/edit-customer";
    }

    @GetMapping ("/customer-delete")
    public String deleteCustomer(@RequestParam Long id){
        this.customerService.deleteCustomer(id);
        return "redirect:/admin/show-list-customer";
    }

}
