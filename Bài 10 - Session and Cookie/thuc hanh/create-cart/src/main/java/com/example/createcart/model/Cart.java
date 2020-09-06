package com.example.createcart.model;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Cart {
     private List<Product> productList =new ArrayList<>();

    public  List<Product> getProductList() {
        return productList;
    }

    public  void setProductList(List<Product> productList) {
        this.productList = productList;

    }

}
