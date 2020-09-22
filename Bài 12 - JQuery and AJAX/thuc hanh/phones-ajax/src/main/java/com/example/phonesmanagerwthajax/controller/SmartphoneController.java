package com.example.phonesmanagerwthajax.controller;

import com.example.phonesmanagerwthajax.model.SmartPhones;
import com.example.phonesmanagerwthajax.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SmartphoneController {

    @Autowired
    private SmartPhoneService smartphoneService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("new-phone");
        mav.addObject("sPhone", new SmartPhones());
        return mav;
    }

    @RequestMapping(value = "/smartphones/createnewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhones createSmartphone(@RequestBody SmartPhones smartphone) {
        return smartphoneService.save(smartphone);
    }

    @RequestMapping(value = "/smartphones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<SmartPhones> allPhones(){
        return smartphoneService.findAll();
    }




    @GetMapping("/smartphones")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("all-phones");

        modelAndView.addObject("allphones", allPhones());
        return modelAndView;
    }
}
