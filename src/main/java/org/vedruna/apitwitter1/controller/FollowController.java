package org.vedruna.apitwitter1.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;

@RequestMapping("api/v1/follows")
public interface FollowController {
    
    @GetMapping("/{username}/following")
    public ResponseEntity<Page<SimpleUserDto>> getAllFollowingByUsername(@PathVariable("username") String username, Pageable pageable, @AuthenticationPrincipal UserDetails me);

    @GetMapping("/{username}/followers")
    public ResponseEntity<Page<SimpleUserDto>> getAllFollowersByUsername(@PathVariable("username") String username, Pageable pageable, @AuthenticationPrincipal UserDetails me);
}
