package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @RequestMapping ("/home")
    public String home(){
        return "page1";
    }
    @RequestMapping ("/calculator")
    public ModelAndView calculator(@RequestParam int num1, @RequestParam int num2, @RequestParam String operator, ModelAndView model){
        int result =0;
        if (operator.equals("+")){
            result=num1+num2;
        }
        if (operator.equals("-")){
            result=num1-num2;
        }
        if (operator.equals("*") || operator.equals("x")){
            result=num1*num2;
        }
        if (operator.equals("/")){
            result=num1/num2;
        }
        model =new ModelAndView("page1","result",result);
        return model;

    }
}
