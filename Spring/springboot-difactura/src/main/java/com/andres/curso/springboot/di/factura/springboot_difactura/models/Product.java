package com.andres.curso.springboot.di.factura.springboot_difactura.models;

public class Product {
    private String namep;
    private Integer price;



    public Product(String namep, Integer price) {
        this.namep = namep;
        this.price = price;
    }
    //GET AND SET
    public String getNamep() {
        return namep;
    }
    public void setNamep(String namep) {
        this.namep = namep;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}
