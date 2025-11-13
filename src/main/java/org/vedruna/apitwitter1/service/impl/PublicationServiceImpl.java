package org.vedruna.apitwitter1.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.vedruna.apitwitter1.persistance.model.Publication;
import org.vedruna.apitwitter1.persistance.model.User;
import org.vedruna.apitwitter1.persistance.repository.PublicationRepository;
import org.vedruna.apitwitter1.persistance.repository.UserRepository;
import org.vedruna.apitwitter1.service.PublicationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PublicationServiceImpl implements PublicationService{
    
    PublicationRepository publicationRepository;
    UserRepository userRepository;


    @Override
    public Page<Publication> getAllPublicationsFromUser(Integer userId, Pageable pageable) {
        return publicationRepository.findPulicationsByUserAuthor_UserId(userId, pageable);
    }


    @Override
    public Page<Publication> getAllPublications(Pageable pageable) {
        return publicationRepository.findAll(pageable);
    }


    @Override
    public Page<Publication> getFeedForUser(String username, Pageable pageable) {
        return publicationRepository.findFeedByFollowerUsername(username, pageable);
    }


    @Override
    public Publication saveNewPublication(Publication newPublication, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalStateException("No existe el usuario con username: " + username + ". Sementalo primero."));

        newPublication.setUserAuthor(user);
        return publicationRepository.save(newPublication);
    }


    @Override
    public Publication updatePublicationById(Integer id, String newText) {
        Publication publication = publicationRepository.findById(id).orElseThrow(() -> new IllegalStateException("No existe la publicacion con id: " + id + ". Sementalo primero."));
        publication.setPublicationText(newText);
        return publicationRepository.save(publication);
    }


    @Override
    public void deletePublicationById(Integer id) {
        publicationRepository.deleteById(id);
    }


    
    
}
