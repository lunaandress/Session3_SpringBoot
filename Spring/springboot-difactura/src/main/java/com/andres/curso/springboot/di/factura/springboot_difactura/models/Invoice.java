package com.andres.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@ApplicationScope //básicamente refuerza lo que ya hace un singleton por defecto.
@RequestScope //Cada vez que llegue una petición al servidor, crea una nueva instancia de esta clase y asi no se mezcla con otros clientes
//@SessionScope //Mientras el usuario no cierre sesión o expire su sesión, usa el mismo objeto.
@JsonIgnoreProperties({
    "advisors",
    "targetSource",
    "targetObject",
    "exposeProxy",
    "targetClass",
    "frozen",
    "preFiltered",
    "proxiedInterfaces",
    "proxyTargetClass",
    "advisorCount"})
public class Invoice {
    @Autowired
    private Client client;
    @Value("${invoice.description.office}")
    private String description;

    //lista de Items qud mostramos en mi 8080
    @Autowired
    private List <Item> Items;

    //metodos de Ciclo de vida
    //Cuando este objeto esté listo, ejecuta este método."
     //Ejecutar un método automáticamente una vez, justo después de que Spring crea el objeto y le inyecta sus dependencias.
    @PostConstruct
    public void init(){
        System.out.println("Creando el Componente de la factura");
        client.setName(client.getName().concat(" PEPE "));
        description=description.concat("del cliente : ").concat(client.getName().concat(client.getLastnameString()));
    }

    //Ejecutar un método automáticamente justo antes de que el objeto (bean) sea destruido.
    //"Antes de cerrar o eliminar este objeto, ejecuta esto."
    //Se ejecuta una sola vez, cuando la aplicación se está cerrando o el bean se elimina.
    @PreDestroy
    public void destroy(){
        System.out.println("destruyendo el componente o bean invoice");
    }

    public int getTotal(){
        int total= 0;

        for (Item item : Items) {
            total+=item.getImporte();
        }
        return total ;
    }



      //GET AND SET

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return Items;
    }
    public void setItems(List<Item> items) {
        Items = items;
    }

}
