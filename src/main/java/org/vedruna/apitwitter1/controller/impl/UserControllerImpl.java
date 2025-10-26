package org.vedruna.apitwitter1.controller.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.apitwitter1.controller.UserController;
import org.vedruna.apitwitter1.controller.converter.SimpleUserConverter;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;
import org.vedruna.apitwitter1.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserControllerImpl implements UserController{

    UserService userService;
   SimpleUserConverter simpleUserConverter;
    
    @Override
    public ResponseEntity<Page<SimpleUserDto>> getAllPlayers(Pageable pageable) {
        return ResponseEntity.ok(
                    userService.getAllUsers(pageable)
                                .map(simpleUserConverter::toDto)
                );
    }
    
}
