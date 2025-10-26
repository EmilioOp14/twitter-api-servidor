package org.vedruna.apitwitter1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.apitwitter1.persistance.model.User;

public interface UserService {

    Page<User> getAllUsers(Pageable pageable);

    Page<User> getUsersByNameStartingWith(String name, Pageable pageable);
    
}
