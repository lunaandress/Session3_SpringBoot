package com.andres.springboot.app.springboot_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.andres.springboot.app.springboot_crud.entities.User;
import com.andres.springboot.app.springboot_crud.repositories.RoleRepository;
import com.andres.springboot.app.springboot_crud.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImple implements UserService {



    @Autowired
    private  UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    //@Transactional(readOnly=true)
    public List<User> findAll() {
        return  (List<User>) repository.findAll();
    }

    @Transactional
    @Override
    public User save(User user) {
        return repository.save(user);
    }

}
