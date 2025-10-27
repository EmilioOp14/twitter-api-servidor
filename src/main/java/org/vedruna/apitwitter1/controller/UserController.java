package org.vedruna.apitwitter1.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;

@RequestMapping("api/v1/users")
public interface UserController {


    @GetMapping("/")
    public ResponseEntity<Page<SimpleUserDto>> getAllPlayers(Pageable pageable);

    @GetMapping("/name")
    public ResponseEntity<Page<SimpleUserDto>> getUsersByNameStartingWith(@RequestParam("q") String prefix, Pageable pageable);

    @PatchMapping("/me/newName")
    public ResponseEntity<Void> updateUserName(@RequestParam("newName") String newName, @AuthenticationPrincipal UserDetails me);


}
