package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.TypeProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService {
    private static Map<Integer, Product> productMap;
    private static List< TypeProduct> typeProducts;


    static {

        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Iphone 5",20000,1,20));
        productMap.put(2, new Product(2, "Iphone 6",30000,1,20));
        productMap.put(3, new Product(3, "Iphone 7",40000,1,20));
        productMap.put(4, new Product(4, "Iphone 8",50000,1,20));
        productMap.put(5, new Product(5, "Ipad 8",50000,2,20));

    }
    static {
        typeProducts=new ArrayList<>();
        typeProducts.add(new TypeProduct(1,"Mobile"));
        typeProducts.add(new TypeProduct(2,"Tablet"));
        typeProducts.add(new TypeProduct(3,"Computer"));
        typeProducts.add(new TypeProduct(4,"Television"));
    }
    @Override
    public List<Product> findAll() {
       return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
          productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
          productMap.get(id).setName(product.getName());
          productMap.get(id).setPrice(product.getPrice());
          productMap.get(id).setIdTypeProduct(product.getIdTypeProduct());
          productMap.get(id).setAmount(product.getAmount());
    }

    @Override
    public void remove(int id) {
           productMap.remove(id);
        System.out.println(productMap.size());
    }

    @Override
    public List<TypeProduct> typeProduct() {
        return typeProducts;
    }
}
