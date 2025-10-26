package org.vedruna.apitwitter1.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.vedruna.apitwitter1.persistance.model.User;
import org.vedruna.apitwitter1.persistance.repository.UserRepository;
import org.vedruna.apitwitter1.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    UserRepository userRepository;


    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        log.info("Buscando todos los usuarios paginados");
        Page<User> users = userRepository.findAll(pageable);
        log.info("Encontrados {} usuarios", users.getTotalElements());
        return users;
    }
    
}
