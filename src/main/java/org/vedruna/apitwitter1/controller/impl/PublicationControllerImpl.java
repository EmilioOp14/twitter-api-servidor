package org.vedruna.apitwitter1.controller.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.apitwitter1.controller.PublicationController;
import org.vedruna.apitwitter1.controller.converter.PublicationConverter;
import org.vedruna.apitwitter1.controller.dto.PublicationDto;
import org.vedruna.apitwitter1.service.PublicationService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
public class PublicationControllerImpl implements PublicationController{
    
    PublicationService publicationService;
    PublicationConverter publicationConverter;
    
    @Override
    public ResponseEntity<Page<PublicationDto>> getPublication(Integer id, Pageable pageable) {
        return ResponseEntity.ok(
            publicationService.getAllPublicationsFromUser(id, pageable)
                .map(f -> publicationConverter.toDto(f))
        );
    }
    
}
