package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoney {
    @GetMapping("/home")
    public String ChangeMoney(){
        return "home";
    }
    @RequestMapping("/Converter")
    public String getConverter(@RequestParam String usd, String rate, Model model){
        Float result = Float.parseFloat(usd)*Float.parseFloat(rate);
        model.addAttribute("result",result);
        return "home";
    }

}
