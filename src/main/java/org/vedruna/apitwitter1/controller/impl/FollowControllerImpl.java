package org.vedruna.apitwitter1.controller.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.apitwitter1.controller.FollowController;
import org.vedruna.apitwitter1.controller.converter.SimpleUserConverter;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;
import org.vedruna.apitwitter1.service.FollowService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
public class FollowControllerImpl implements FollowController{
    
    FollowService followService;
    SimpleUserConverter simpleUserConverter;
    
    @Override
    public ResponseEntity<Page<SimpleUserDto>> getAllFollowingByUsername(String username, Pageable pageable) {
        return ResponseEntity.ok(followService.getAllFollowingByUsername(username, pageable).map(simpleUserConverter::toDto));
    }

    @Override
    public ResponseEntity<Page<SimpleUserDto>> getAllFollowersByUsername(String username, Pageable pageable) {
        return ResponseEntity.ok(followService.getAllFollowersByUsername(username, pageable).map(simpleUserConverter::toDto));
    }
    
}
