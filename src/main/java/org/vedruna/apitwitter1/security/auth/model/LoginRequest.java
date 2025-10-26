package org.vedruna.apitwitter1.security.auth.model;

import lombok.Data;

@Data
public class LoginRequest {
    String username;
    String password;
}
