package com.andres.springboot.app.springboot_crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.app.springboot_crud.entities.Role;

public interface RoleRepository extends CrudRepository<Role,Long> {

    Optional<Role>findByName(String role);
}
