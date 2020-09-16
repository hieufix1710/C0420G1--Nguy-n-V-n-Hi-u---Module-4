package com.example.controller;

import com.example.entity.model.Service;
import com.example.service.modelSer.IService;
import com.example.service.modelSer.ITypeRent;
import com.example.service.modelSer.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/admin")
public class ServiceController {

    @Autowired
    private IService iService;
    @Autowired
    private ITypeRent typeRent;
    @Autowired
    private ITypeService typeService;

    @GetMapping ("/services")
    public String showServices(Model model, Pageable pageable, @RequestParam (value = "search",defaultValue = "") String search){
        model.addAttribute("services",iService.findAll(pageable, search));
        model.addAttribute("search",search);
        return "service/list-service";
    }

    @GetMapping ("/create-new-service")
    public String createNewServiceForm(Model model){
        model.addAttribute("service",new Service());
        model.addAttribute("typeRents",this.typeRent.findAllTypeRent());
        model.addAttribute("typeServices",this.typeService.findAllTypeService());
        return "service/create-service-form";
    }

    @PostMapping("/create-new-service")
    public String createNewService(@Validated  @ModelAttribute("service") Service service, Model model, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "service/create-service-form";
        }
        this.iService.saveService(service);
        model.addAttribute("message","Create success !");
        return "service/create-service-form";
    }


}
