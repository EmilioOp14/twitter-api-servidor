package org.vedruna.apitwitter1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.apitwitter1.persistance.model.Publication;

public interface PublicationService {

    Page<Publication> getAllPublicationsFromUser(Integer userId, Pageable pageable);

    Page<Publication> getAllPublications(Pageable pageable);

    Page<Publication> getFeedForUser(String username, Pageable pageable);

    Publication saveNewPublication(Publication newPublication, String username);

    Publication updatePublicationById(Integer id, String newText);

    void deletePublicationById(Integer id);
    
}
