package org.vedruna.apitwitter1.controller.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Override
    public ResponseEntity<Page<PublicationDto>> getAllPublications(Pageable pageable) {
        return ResponseEntity.ok(
            publicationService.getAllPublications(pageable)
                .map(f -> publicationConverter.toDto(f))
        );
    }

    @Override
public ResponseEntity<Page<PublicationDto>> getMyFeed(Pageable pageable) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName(); // viene del token JWT

    return ResponseEntity.ok(
        publicationService.getFeedForUser(username, pageable)
            .map(publicationConverter::toDto)
    );
}

    @Override
    public ResponseEntity<PublicationDto> createPublication(PublicationDto publicationDto, UserDetails me) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            publicationConverter.toDto(
                publicationService.saveNewPublication(publicationConverter.toEntity(publicationDto), me.getUsername())
            ));
        
    }

    @Override
    public ResponseEntity<PublicationDto> updatePublication(Integer id, PublicationDto publicationDto, UserDetails me) {
        return ResponseEntity.ok(
            publicationConverter.toDto(
                publicationService.updatePublicationById(id, publicationDto.getPublicationText())
            ));
    }

    @Override
    public ResponseEntity<Void> deletePublication(Integer id, UserDetails me) {
        publicationService.deletePublicationById(id);
        return ResponseEntity.noContent().build();
    }

    
}
