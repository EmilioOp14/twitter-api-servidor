package org.vedruna.apitwitter1.security.auth.services;

import org.vedruna.apitwitter1.security.auth.model.AuthResponse;
import org.vedruna.apitwitter1.security.auth.model.LoginRequest;
import org.vedruna.apitwitter1.security.auth.model.RegisterRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
    
    
}
