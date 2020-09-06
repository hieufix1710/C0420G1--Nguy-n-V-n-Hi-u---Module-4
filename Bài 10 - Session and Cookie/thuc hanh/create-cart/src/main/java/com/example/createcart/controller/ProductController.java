package com.example.createcart.controller;

import com.example.createcart.model.Cart;
import com.example.createcart.model.Product;
import com.example.createcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;


    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @RequestMapping("/home-page")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView("home-page");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-new-product")
    public ModelAndView createFrom() {
        return new ModelAndView("create-new-product", "product", new Product());
    }

    @PostMapping("/create-new-product")
    public ModelAndView createNewProduct(@ModelAttribute("product") Product product) {
        this.productService.save(product);
        return new ModelAndView("create-new-product", "message", "Create success !");
    }

    @GetMapping("/show-infor/")
    public ModelAndView showInforProduct(@RequestParam Long id) {
        return new ModelAndView("view-product", "product", productService.findById(id));
    }


    @GetMapping("/add-to-cart")
    public ModelAndView addToCart(@RequestParam long id, @ModelAttribute("cart") Cart cart) {
        Product product = this.productService.findById(id);
        cart.getProductList().add(product);
        return new ModelAndView("home-page");
    }

    @GetMapping("/show-cart")
    public ModelAndView showCart(@ModelAttribute("cart") Cart cart) {
        List<Product> products = cart.getProductList();

        if (products.isEmpty()) {
            return new ModelAndView("cart-list", "message", "Bạn chưa mua gì cả ~.~");
        }
        return new ModelAndView("cart-list", "products", products);
    }



}
