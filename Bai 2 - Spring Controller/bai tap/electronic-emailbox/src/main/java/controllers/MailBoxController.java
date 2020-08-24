package controllers;

import model.Languages;
import model.MailBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.MailBoxService;

@Controller

@RequestMapping
public class MailBoxController {

    private MailBoxService mailBoxService= new MailBoxService();

    @GetMapping ("/home")
    public ModelAndView showHome(){
        ModelAndView modelAndView=new ModelAndView("form","mailboxs",mailBoxService.findAll());
        return modelAndView;
    }
    @GetMapping ("/showInfo&id={id}")
    public String showInfo(@PathVariable int id, Model model){
       model.addAttribute("mailbox",this.mailBoxService.findById(id));
       model.addAttribute("languages",this.mailBoxService.typeLanguages());
       return "info";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("languages",this.mailBoxService.typeLanguages());
        model.addAttribute("mailbox",new MailBox());
        return "create";
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute ("mailbox") MailBox mailBox){
        this.mailBoxService.save(mailBox);
        return showHome();
    }
}
