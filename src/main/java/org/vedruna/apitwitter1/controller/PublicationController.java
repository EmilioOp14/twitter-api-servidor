package org.vedruna.apitwitter1.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vedruna.apitwitter1.controller.dto.PublicationDto;

@RequestMapping("api/v1/publications")
public interface PublicationController {

    @GetMapping("/")
    public ResponseEntity<Page<PublicationDto>> getAllPublications(Pageable pageable);

    @GetMapping("/{id}")
    public ResponseEntity<Page<PublicationDto>> getPublication(@PathVariable("id") Integer id, Pageable pageable);

    @GetMapping("/feed")
ResponseEntity<Page<PublicationDto>> getMyFeed(Pageable pageable);

    @PostMapping("/")
    public ResponseEntity<PublicationDto> createPublication(@RequestBody PublicationDto publicationDto, @AuthenticationPrincipal UserDetails me);

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDto> updatePublication(@PathVariable("id") Integer id, @RequestBody PublicationDto publicationDto, @AuthenticationPrincipal UserDetails me);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable("id") Integer id, @AuthenticationPrincipal UserDetails me);
    
}
