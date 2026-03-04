package com.andres.curso.springboot.di.factura.springboot_difactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {


@Value("${client.name}")
private String name ;
@Value("${client.lastname}")
private String lastname ;




//GET AND SET
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getLastnameString() {
    return lastname;
}
public void setLastnameString(String lastnameString) {
    this.lastname = lastnameString;
}
}
