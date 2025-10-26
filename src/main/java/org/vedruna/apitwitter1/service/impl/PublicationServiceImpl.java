package org.vedruna.apitwitter1.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.vedruna.apitwitter1.persistance.model.Publication;
import org.vedruna.apitwitter1.persistance.repository.PublicationRepository;
import org.vedruna.apitwitter1.service.PublicationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PublicationServiceImpl implements PublicationService{
    
    PublicationRepository publicationRepository;


    @Override
    public Page<Publication> getAllPublicationsFromUser(Integer userId, Pageable pageable) {
        return publicationRepository.findPulicationsByUserAuthor_UserId(userId, pageable);
    }
    
}
