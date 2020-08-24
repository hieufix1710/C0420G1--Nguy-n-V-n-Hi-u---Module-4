package controllers;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employee/")
public class EmployeeController {

   @GetMapping("showform")
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping ("/addEmployee")
    public ModelAndView submit(@ModelAttribute("employee") Employee employee) {
        ModelAndView modelAndView=new ModelAndView("info","employee",employee);
        return modelAndView;
    }
}