package com.andres.springboot.app.springboot_crud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Size(min = 3,  max = 20)//aqui pongo el minimo y el maximo
    @NotEmpty(message = "{NotEmpty.product.name}") // con esto le digo que mi variable no sea vacia  ojo  empy solo con string
    private String name;

    @Min(value = 500 , message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private int price ;

    @NotBlank(message = "{NotBlank.product.description}")
    private String description;

    
    public Product() {
    }

    public Product(Long id,String name ,int price, String description) {
        this.id = id;
        this.name=name;
        this.price = price;
        this.description = description;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
    }

    
    

    

}
