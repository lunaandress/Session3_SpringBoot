package com.andres.springboot.app.springboot_crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig {

    // PasswordEncoder ->Convierte una contraseña normal en una contraseña encriptada (hash)
    @Bean // generea un componente sping y poderlo inyectar con el Autowired
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }



}
