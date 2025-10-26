package org.vedruna.apitwitter1.security.auth.services;

import java.security.Key;
import java.util.Map;

import org.vedruna.apitwitter1.persistance.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String getToken(User user);

    String getToken(Map<String, Object> extraClaims, User user);

    Key getKey();

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
