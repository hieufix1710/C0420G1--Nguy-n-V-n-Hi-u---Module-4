package com.example.controller;

import com.example.entity.model.Contract;
import com.example.service.modelSer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
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
    public String showListContract(Pageable pageable, @RequestParam (value = "search",defaultValue = "") String search,Model model){
        model.addAttribute("contracts",this.iContract.findAllContract(pageable, search));
        model.addAttribute("search",search);

        return "contract/list-contract";
    }

    @GetMapping ("/create-new-contract")
    public String createContractForm(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("customers",this.iCustomer.findAll());
        model.addAttribute("employees",this.iEmployee.findAllEmployee());
        model.addAttribute("services",this.iService.findAll());
        return "contract/create-contract-form";
    }

    @PostMapping("/create-new-contract")
    public String createContract(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "contract/create-contract-form";
        }else {
            this.iContract.saveContract(contract);
            model.addAttribute("message","Created !");
            return "contract/create-contract-form";
        }
    }

    // contract details

    @GetMapping("/contract-details")
    public String showListContractDetails(Pageable pageable,@RequestParam (value = "search",defaultValue = "")String search,Model model){

        model.addAttribute("contractDetails",this.iContractDetails.findAllDetailContract(pageable, search));
        model.addAttribute("contracts",this.iContract.findAllContract());
        model.addAttribute("search",search);
        return "contract/list-contract-details";

    }
}
