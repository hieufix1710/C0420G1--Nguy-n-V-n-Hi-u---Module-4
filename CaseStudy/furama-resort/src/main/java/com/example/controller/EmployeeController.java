package com.example.controller;

import com.example.service.modelSer.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/admin")
public class EmployeeController {

    @Autowired
    private IEmployee iEmployee;

    @GetMapping("/show-list-employee")
    public String showListEmployee(Model model, Pageable pageable, @RequestParam (value = "search",defaultValue = "") String search){
        model.addAttribute("employees",iEmployee.findAllEmployee(pageable, search));
        model.addAttribute("search",search);
        return "employee/list-employee";
    }
    @GetMapping("/create-new-employee")
    public String createEmployeeForm(){
        return "employee/create-employee-form";
    }

}
