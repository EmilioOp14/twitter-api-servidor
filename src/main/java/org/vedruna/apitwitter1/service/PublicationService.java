package org.vedruna.apitwitter1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.apitwitter1.persistance.model.Publication;

public interface PublicationService {

    Page<Publication> getAllPublicationsFromUser(Integer userId, Pageable pageable);
    
}
