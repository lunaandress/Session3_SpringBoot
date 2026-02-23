package com.andres.springboot.di.app.spinboot_di.repositories;

import java.util.List;
import java.util.Optional;

import com.andres.springboot.di.app.spinboot_di.models.Product;

public interface IProductRepository {
    List<Product>findAll();
    Optional<Product> findById(long id);

}
