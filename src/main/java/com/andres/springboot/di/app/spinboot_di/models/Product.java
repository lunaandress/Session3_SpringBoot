package com.andres.springboot.di.app.spinboot_di.models;

public class Product implements Cloneable {
private long id;
private String name ;
private  long price ;

//CLASE POJO

//constructor
public Product() {

}

public Product(long id, String name, long price) {
    this.id = id;
    this.name = name;
    this.price = price;
}

// get and set

public long getId() {
    return id;
}



public void setId(long id) {
    this.id = id;
}



public String getName() {
    return name;
}



public void setName(String name) {
    this.name = name;
}



public long getPrice() {
    return price;
}



public void setPrice(long price) {
    this.price = price;
}

@Override
public Object clone()  {
    try {
        return super.clone();
    } catch (CloneNotSupportedException e) {
        return new Product(this.getId(),this.getName(), getPrice());
    }
}











}
