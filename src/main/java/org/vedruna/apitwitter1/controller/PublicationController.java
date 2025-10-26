package org.vedruna.apitwitter1.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vedruna.apitwitter1.controller.dto.PublicationDto;

@RequestMapping("api/v1/publications")
public interface PublicationController {

    @GetMapping("/{id}")
    public ResponseEntity<Page<PublicationDto>> getPublication(@PathVariable("id") Integer id, Pageable pageable);
    
}
