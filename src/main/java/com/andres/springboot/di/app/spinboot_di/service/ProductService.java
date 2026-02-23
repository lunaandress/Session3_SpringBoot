package com.andres.springboot.di.app.spinboot_di.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.andres.springboot.di.app.spinboot_di.models.Product;
import com.andres.springboot.di.app.spinboot_di.repositories.ProductRespository;

//El service accede a los datos mediante al repositorio pero ademas
    //los puede manipular y trabajar con ellos.


public class ProductService implements IProductService {


private ProductRespository respository= new ProductRespository();

//METODOS

@Override
public List<Product>findAll(){
    
    //principio de imutabilidad
    return respository.findAll().stream().map(p -> {
        Double priceTax= p.getPrice() * 1.25d;
       // Product newProduct = new Product(p.getId(),p.getName(),priceImp.longValue());
        Product newProduct =  (Product)p.clone();
        newProduct.setPrice(priceTax.longValue());
        return newProduct;
    }).collect(Collectors.toList());
}

@Override
public Optional<Product> findById(long id){
    return respository.findById(id);
}












}
