package com.codegym.model;

public class Product {
    private  int id;
    private String name;
    private double price;
    private int  idTypeProduct;
    private int  amount;

    public Product() {
    }

    public Product(int id, String name, double price, int idTypeProduct, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idTypeProduct = idTypeProduct;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(int idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}

