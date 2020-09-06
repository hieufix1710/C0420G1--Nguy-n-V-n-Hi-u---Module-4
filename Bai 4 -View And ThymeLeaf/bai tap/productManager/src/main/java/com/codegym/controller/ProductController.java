package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.TypeProduct;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService=new ProductServiceImp();
    @RequestMapping ("/products")
    public String displayList(Model model){
        model.addAttribute("products",this.productService.findAll());
        model.addAttribute("typeProducts",this.productService.typeProduct());
        return "home";
    }
    @GetMapping ("/products/create")
    public String createForm(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("typeProducts",this.productService.typeProduct());
        return "create";
    }
    @PostMapping ("/products/create")
    public ModelAndView create(@ModelAttribute ("product") Product product){
        System.out.println(product.toString());
        this.productService.save(product);
        return new ModelAndView("create","message","Create success !");

    }
    @GetMapping ("/products/delete")
    public String delete (@RequestParam int id,Model model){
       this.productService.remove(id);
        model.addAttribute("products",this.productService.findAll());
        model.addAttribute("typeProducts",this.productService.typeProduct());
            return displayList(model);

    }
    @GetMapping ("/products/view")
    public String view(@RequestParam int id,Model model){
        model.addAttribute("product",this.productService.findById(id));
        model.addAttribute("typeProduct",this.productService.typeProduct());
        return "view";
    }
    @GetMapping("/products/edit")
    public String updateForm(@RequestParam int id,Model model){
       model.addAttribute("product",this.productService.findById(id));
        model.addAttribute("typeProducts",this.productService.typeProduct());
        return "edit";
    }
    @PostMapping ("/products/update")
    public ModelAndView update(@ModelAttribute ("product") Product product){
        this.productService.update(product.getId(),product);
        return new ModelAndView("edit","message","Update success !");
    }
}
