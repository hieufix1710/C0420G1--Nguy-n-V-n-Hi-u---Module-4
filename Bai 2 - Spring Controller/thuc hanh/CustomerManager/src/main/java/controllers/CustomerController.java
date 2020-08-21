package controllers;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
import service.CustomerServiceImp;



@RequestMapping ("/customers")
@Controller
public class CustomerController {
   CustomerService customerService=new CustomerServiceImp();

   @GetMapping ("")
    public ModelAndView listCustomer(){
       ModelAndView modelAndView=new ModelAndView("list");
       modelAndView.addObject("customers",customerService.findAll());
       return modelAndView;
   }

   @GetMapping("/delete&{id}")
   public ModelAndView delete(@PathVariable int id ){
      this.customerService.delete(id);
      return listCustomer();
   }
  
}
