package com.andres.springboot.jpa.springboot_jpa.respositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.jpa.springboot_jpa.entities.Person;

// rudRepository<Person,Long> Te da automáticamente operaciones CRUD:
//<Person, Long>  es la : <Entity, idEntity>
public interface PersonRepository  extends CrudRepository<Person,Long> {

}
