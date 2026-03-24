package com.andres.springboot.app.springboot_crud.security.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.andres.springboot.app.springboot_crud.entities.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

private AuthenticationManager authenticationManager;

public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {

    authenticationManager = authenticationManager;
}

@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException {
User user = null;
String username=null;
String password=null;

try {
    user = new ObjectMapper().readValue(request.getInputStream(), User.class);
    username = user.getUsername();
    password = user.getPassword();
} catch (JacksonException | IOException e) {
    e.printStackTrace();
}

UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);


    return authenticationManager.authenticate(authenticationToken);
}




}
