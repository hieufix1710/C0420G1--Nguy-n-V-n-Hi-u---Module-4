package com.codegym.furamaspringboot.controller;

import com.codegym.furamaspringboot.model.Contract;
import com.codegym.furamaspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/furama")
public class ContractController {

    @Autowired
    private IContract iContract;
    @Autowired
    private ICustomer iCustomer;

    @Autowired
    private IService iService;

     @Autowired
     private IEmployee iEmployee;

     @Autowired
     private IAttachService attachService;

     @Autowired
     private IContractDetails iContractDetails;


    @GetMapping("/contract-list")
    public ModelAndView showListContract(Pageable pageable, @RequestParam (value = "search",defaultValue = "") String search){
        ModelAndView modelAndView=new ModelAndView("list-contract");
        modelAndView.addObject("contracts",this.iContract.findAllContract(pageable, search));
        modelAndView.addObject("search",search);
        return modelAndView;
    }

    @GetMapping ("/create-new-contract")
    public ModelAndView createContractForm(){
        ModelAndView modelAndView=new ModelAndView("create-contract-form");
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("customers",this.iCustomer.findAll());
        modelAndView.addObject("employees",this.iEmployee.findAllEmployee());
        modelAndView.addObject("services",this.iService.findAll());
        return modelAndView;
    }

    @PostMapping ("/create-new-contract")
    public ModelAndView createContract(@Validated @ModelAttribute ("contract") Contract contract, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("create-contract-form");
        }else {
            this.iContract.saveContract(contract);
            return new ModelAndView("create-contract-form","message","Create success !");
        }
    }

    // contract details

    @GetMapping("/contract-details")
    public ModelAndView showListContractDetails(Pageable pageable,@RequestParam (value = "search",defaultValue = "")String search){
        ModelAndView modelAndView=new ModelAndView("list-contract-details");
        modelAndView.addObject("contractDetails",this.iContractDetails.findAllDetailContract(pageable, search));
        modelAndView.addObject("contracts",this.iContract.findAllContract());
        modelAndView.addObject("search",search);
        return modelAndView;

    }
}
