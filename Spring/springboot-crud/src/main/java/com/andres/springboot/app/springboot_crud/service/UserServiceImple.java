package com.andres.springboot.app.springboot_crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.andres.springboot.app.springboot_crud.entities.Role;
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
    private PasswordEncoder passwordEncoder;//codificamos el password



    @Override
    //@Transactional(readOnly=true)
    public List<User> findAll() {
        return  (List<User>) repository.findAll();
    }


    
    @Transactional
    @Override
    public User save(User user) {
        Optional<Role>optionalRolUser = roleRepository.findByName("ROLE_USER");

        List<Role>roles = new ArrayList<>();

        optionalRolUser.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Role> optionalRoleAdm= roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdm.ifPresent(roles::add);
        }

        user.setRoles(roles);

        //codificamos el password
        String passwordEncoded= passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        return repository.save(user);
    }

}
