package org.vedruna.apitwitter1.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;

@RequestMapping("api/v1/users")
public interface UserController {


    @GetMapping("/")
    public ResponseEntity<Page<SimpleUserDto>> getAllPlayers(Pageable pageable);

}
