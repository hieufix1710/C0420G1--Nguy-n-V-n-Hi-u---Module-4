package com.example.controller;

import com.example.model.Food;
import com.example.service.FoodService;
import com.example.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private TypeService typeService;


    @GetMapping (value = {"/",""})
    public String showList(Model model){
        model.addAttribute("foods",foodService.findAll());
        return "list";
    }

    @GetMapping (value = "/search")
    @ResponseBody
    public List<Food> search(@RequestParam String search, Model model){
        List<Food> foodList=foodService.findByName(search);
        model.addAttribute("foods",foodList);
       return foodList;
    }

    @GetMapping("/create-new-food")
    public String createForm(Model model){
        model.addAttribute("food",new Food());
        model.addAttribute("types",typeService.findAll());
        return "createForm";
    }

    @PostMapping ("/create-new-food")
    public String create(@ModelAttribute ("food") Food food,Model model){
        foodService.save(food);
        model.addAttribute("message","Created !");
        return "createForm";
    }



}
