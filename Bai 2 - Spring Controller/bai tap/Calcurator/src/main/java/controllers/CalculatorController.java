package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CalculatorService;

@Controller
public class CalculatorController {
    private CalculatorService calculatorService= new CalculatorService();
    @RequestMapping ("/home")
    public String home(){
        return "page1";
    }
    @RequestMapping ("/calculator")
    public ModelAndView calculator(@RequestParam int num1, @RequestParam int num2, @RequestParam String operator){
        if (calculatorService.calculator(num1,num2,operator)==-1){
            ModelAndView modelAndView=new ModelAndView("page1","message","Operator not valid !");
            return modelAndView;
        }
      ModelAndView modelAndView1=new ModelAndView("page1","result",calculatorService.calculator(num1,num2,operator));
      return modelAndView1;

    }
}
