package com.andres.springboot.app.springboot_crud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.app.springboot_crud.entities.Product;
import com.andres.springboot.app.springboot_crud.repositories.ProductRepository;
import com.andres.springboot.app.springboot_crud.service.ProductService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/products")
public class ProductController {


private final ProductRepository productRepository;

@Autowired
private ProductService productService;

ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
}

@GetMapping("")
public List<Product>list(){
return productService.findAll();
}


//MOSTRAR

@GetMapping("/{id}")
public ResponseEntity<?> view(  @PathVariable Long id) {
    Optional<Product> prodOpt=productService.findById(id);
    if (prodOpt.isPresent()) {
        return ResponseEntity.ok(prodOpt.orElseThrow());
    }
    return ResponseEntity.notFound().build();
}


//CREAR NUEVO
//validamos data con la dependencia Validate
@PostMapping
public ResponseEntity<?> create(@Valid @RequestBody Product product , BindingResult result) {
    if (result.hasFieldErrors()) {
        return validation(result);
    }
    Product saved = productService.save(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}


//ACTUALIZAR
@PutMapping("/{id}")
public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Product product ,BindingResult result) {
    Optional<Product> prodOpt = productService.findById(id);
    if (result.hasFieldErrors()) {
        return validation(result);
    }
    if (prodOpt.isPresent()) {
        product.setId(id); // importante
        Product updated = productService.save(product);
        return ResponseEntity.ok(updated);
    }

    return ResponseEntity.notFound().build();
}


//ELIMINAR

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(  @PathVariable Long id) {
    Product product= new Product();
    product.setId(id);
    Optional<Product> prodOpt=productService.delete(product);
    if (prodOpt.isPresent()) {
        return ResponseEntity.ok(prodOpt.orElseThrow());
    }
    return ResponseEntity.notFound().build();
}


//METODO DE VALIDACION

private ResponseEntity<Map<String, String>> validation(BindingResult result) {
    Map<String, String> errors = new HashMap<>();

    result.getFieldErrors().forEach(err -> {
        errors.put(err.getField(), "EL CAMPO " + err.getField() + " " + err.getDefaultMessage());
    });

    return ResponseEntity.badRequest().body(errors);
}


}



