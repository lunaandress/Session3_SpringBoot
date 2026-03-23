package com.andres.springboot.app.springboot_crud.service;

import java.util.List;

import com.andres.springboot.app.springboot_crud.entities.User;

public interface UserService {

    List<User>findAll();
    User save (User user);

}
