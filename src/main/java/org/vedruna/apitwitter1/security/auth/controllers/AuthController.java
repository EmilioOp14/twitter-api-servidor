package org.vedruna.apitwitter1.security.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.apitwitter1.security.auth.model.AuthResponse;
import org.vedruna.apitwitter1.security.auth.model.LoginRequest;
import org.vedruna.apitwitter1.security.auth.model.RegisterRequest;
import org.vedruna.apitwitter1.security.auth.services.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@AllArgsConstructor
public class AuthController {
    
    
    AuthService authService;


    @PostMapping(value = "/login")
    // @Operation(summary = "Loguear usuario")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }



    @PostMapping(value = "/register")
    // @Operation(summary = "Registrar usuario")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
