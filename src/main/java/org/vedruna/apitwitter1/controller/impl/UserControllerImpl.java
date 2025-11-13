package org.vedruna.apitwitter1.controller.impl;

import java.nio.file.attribute.UserPrincipal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.apitwitter1.controller.UserController;
import org.vedruna.apitwitter1.controller.converter.SimpleUserConverter;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;
import org.vedruna.apitwitter1.persistance.model.User;
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

    @Override
    public ResponseEntity<Page<SimpleUserDto>> getUsersByNameStartingWith(String prefix, Pageable pageable) {
        return ResponseEntity.ok(
            userService.getUsersByNameStartingWith(prefix, pageable)
                .map(f -> simpleUserConverter.toDto(f))
        );
    }

    @Override
    public ResponseEntity<Void> updateUserName(String newName, UserDetails me) {
        String username = me.getUsername();
        userService.updateUserName(username, newName);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<SimpleUserDto> getMe(UserDetails me) {
        User user = userService.getUserByUsername(me.getUsername());
        return ResponseEntity.ok(simpleUserConverter.toDto(user));
    }

}
    

