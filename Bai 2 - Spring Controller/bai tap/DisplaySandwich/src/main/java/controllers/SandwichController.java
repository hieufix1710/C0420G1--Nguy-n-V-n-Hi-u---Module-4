package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class SandwichController {
    @RequestMapping ("/home")
    public String home(){
        return "page";
    }
    @RequestMapping("/save")
    public ModelAndView save(@RequestParam("condiment") String condiment, ModelAndView modelAndView) {
           modelAndView =new ModelAndView("page","condiment",condiment);
           return modelAndView;
    }
}
