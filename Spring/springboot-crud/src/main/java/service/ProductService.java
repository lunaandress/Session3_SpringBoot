package service;

import java.util.List;
import java.util.Optional;

import entities.Product;

public interface ProductService {

    List<Product>findAll();
    Optional <Product> findById(long id);// el Opcional es in contenedor que solo puede tener  0 a 1 Objeto
    Product save(Product product);
    Optional<Product> delete(Product product);

}
