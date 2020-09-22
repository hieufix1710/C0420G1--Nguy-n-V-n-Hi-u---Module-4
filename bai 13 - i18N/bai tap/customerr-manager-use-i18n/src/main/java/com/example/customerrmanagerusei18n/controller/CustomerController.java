package com.example.customerrmanagerusei18n.controller;


import com.example.customerrmanagerusei18n.service.CusSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private CusSer cusSer;

    @GetMapping(value = {"/customer","","/"})
    public ModelAndView getAll(){
        return new ModelAndView("list-customer","customers",cusSer.findAll());
    }

}
