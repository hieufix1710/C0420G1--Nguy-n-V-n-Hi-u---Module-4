package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping ("/home")
    public String home(){
        return "page1";
    }
    @RequestMapping ("/calculator")
    public String calculator(@RequestParam int num1,@RequestParam int num2,@RequestParam String operator){
        if (operator.equals("+")){
            
        }
    }
}
