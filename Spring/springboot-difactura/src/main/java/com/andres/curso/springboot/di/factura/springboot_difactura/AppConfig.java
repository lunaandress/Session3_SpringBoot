package com.andres.curso.springboot.di.factura.springboot_difactura;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.andres.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.andres.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    // Bean que devuelve una lista de Items
    @Bean
    public List<Item> items() {
        List<Item> items = new ArrayList<>();

        // Creamos los productos
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Bicicleta Bianchi 26", 1200);

        // Creamos los objetos Item con producto y cantidad
        Item item1 = new Item();
        item1.setProduct(p1);
        item1.setQuantity(2);

        Item item2 = new Item();
        item2.setProduct(p2);
        item2.setQuantity(5);

        // Agregamos los Item a la lista
        items.add(item1);
        items.add(item2);

        return items;
    }

        //CUANDO TENGO DOS BEANS TENGO QUE VER CUAL BEAN INYECTAR usamos el @PRIMARY
    @Bean
    @Primary
    public List<Item> itemsOffices() {
        List<Item> items = new ArrayList<>();

        // Creamos los productos
        Product p1 = new Product("MONITOR ASUS 24", 700);
        Product p2 = new Product("NOTEBOOK RAZER", 2400);
        Product p3 = new Product("IMPRESORA HP ", 800);
        Product p4 = new Product(" ESCITORIO OFICINA", 900);

        // Creamos los objetos Item con producto y cantidad
        Item item1 = new Item();
        item1.setProduct(p1);
        item1.setQuantity(4);

        Item item2 = new Item();
        item2.setProduct(p2);
        item2.setQuantity(6);
        
        Item item3 = new Item();
        item3.setProduct(p3);
        item3.setQuantity(1);

        Item item4 = new Item();
        item4.setProduct(p4);
        item4.setQuantity(4);

        // Agregamos los Item a la lista
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        return items;
    }
}