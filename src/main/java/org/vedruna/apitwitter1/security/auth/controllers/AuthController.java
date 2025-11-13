package org.vedruna.apitwitter1.security.auth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.apitwitter1.controller.converter.SimpleUserConverter;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;
import org.vedruna.apitwitter1.security.auth.model.AuthResponse;
import org.vedruna.apitwitter1.security.auth.model.LoginRequest;
import org.vedruna.apitwitter1.security.auth.model.RegisterRequest;
import org.vedruna.apitwitter1.security.auth.services.impl.AuthServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@AllArgsConstructor
public class AuthController {
    
    
    AuthServiceImpl authService;
    SimpleUserConverter userConverter;


    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
            authService.login(
                    userConverter.loginToEntity(request)
            ));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<SimpleUserDto> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            userConverter.toDto(  
                authService.register(
                    userConverter.registerToEntity(request)
                )
            )
            
        );
    }


    // @PostMapping(value = "/register")
    // // @Operation(summary = "Registrar usuario")
    // public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
    //     return ResponseEntity.ok(authService.register(request));
    // }
}
