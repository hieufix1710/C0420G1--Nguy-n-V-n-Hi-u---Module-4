package com.codegym.provindecustomer.controller;

import com.codegym.provindecustomer.model.Customer;
import com.codegym.provindecustomer.service.CustomerService;
import com.codegym.provindecustomer.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    //    public String list(Model model){
//        model.addAttribute("customers",this.customerService.findAll());
//        model.addAttribute("provinces",this.provinceService.findAll());
//        return "list";
//    }
    @GetMapping("/customers")
    public String list(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search, Model model) {
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("search", search);
        return "list";

    }

    @GetMapping("/customers/create")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("provinces", this.provinceService.findAll());
        return "create";
    }
    @PostMapping("/customers/create")
    public ModelAndView create(@ModelAttribute("customer") Customer customer) {
        this.customerService.save(customer);
        return new ModelAndView("create", "message", "Create success !");
    }


    @GetMapping("/customers/edit/")
    public String editForm(@RequestParam Long id,Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        model.addAttribute("provinces", this.provinceService.findAll());
        return "edit";
    }


   @PostMapping("/customers/update")
    public ModelAndView update(@ModelAttribute("customer") Customer customer) {
        this.customerService.update(customer.getId(),customer);
        return new ModelAndView("edit", "message", "Update success !");
    }

    @GetMapping("/customers/delete/")
    public String editForm(@RequestParam Long id ) {
        this.customerService.delete(id);
        return "redirect:/customers";
    }
}
