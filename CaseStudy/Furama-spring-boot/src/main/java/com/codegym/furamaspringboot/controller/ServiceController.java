package com.codegym.furamaspringboot.controller;

import com.codegym.furamaspringboot.model.Service;
import com.codegym.furamaspringboot.service.IService;
import com.codegym.furamaspringboot.service.ITypeRent;
import com.codegym.furamaspringboot.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/furama-resort")
public class ServiceController {

    @Autowired
    private IService service;
    @Autowired
    private ITypeRent typeRent;
    @Autowired
    private ITypeService typeService;
    @GetMapping ("/services")
    public ModelAndView showListService(Pageable pageable, @RequestParam (value = "search",defaultValue = "") String search){
        ModelAndView modelAndView=new ModelAndView("list-service");
        modelAndView.addObject("services",this.service.findAll(pageable, search));
        modelAndView.addObject("search",search);
        return modelAndView;
    }

    @GetMapping ("/create-new-service")
    public ModelAndView createNewServiceForm(){
        ModelAndView modelAndView=new ModelAndView("create-service-form");
        modelAndView.addObject("service",new Service());
        modelAndView.addObject("typeRents",this.typeRent.findAllTypeRent());
        modelAndView.addObject("typeServices",this.typeService.findAllTypeService());
        return modelAndView;
    }

    @PostMapping ("/create-new-service")
    public ModelAndView createNewService(@ModelAttribute ("service") Service service){
        this.service.saveService(service);
        return new ModelAndView("create-service-form","message","Create success !");
    }


}
