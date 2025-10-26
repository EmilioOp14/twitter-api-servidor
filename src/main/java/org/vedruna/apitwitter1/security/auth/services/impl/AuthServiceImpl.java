package org.vedruna.apitwitter1.security.auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.vedruna.apitwitter1.persistance.model.Rol;
import org.vedruna.apitwitter1.persistance.model.User;
import org.vedruna.apitwitter1.persistance.repository.RolRepository;
import org.vedruna.apitwitter1.persistance.repository.UserRepository;
import org.vedruna.apitwitter1.security.auth.model.AuthResponse;
import org.vedruna.apitwitter1.security.auth.model.LoginRequest;
import org.vedruna.apitwitter1.security.auth.model.RegisterRequest;
import org.vedruna.apitwitter1.security.auth.services.AuthService;
import org.vedruna.apitwitter1.security.auth.services.JWTService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
    
    
    UserRepository userRepository;

    RolRepository rolRepository;

    
    JWTService jwtService;

    
    PasswordEncoder passwordEncoder;

    
    AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        return new AuthResponse(jwtService.getToken(user));
    }

 public AuthResponse register(RegisterRequest request) {
    User user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    Rol rol = rolRepository.findByRolName("USER")
        .orElseThrow(() -> new IllegalStateException("No existe el rol USER. Sementalo primero."));
    user.setUserRol(rol);

    userRepository.save(user);
    return new AuthResponse(jwtService.getToken(user));
}

}
