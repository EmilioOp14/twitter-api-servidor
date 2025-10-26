package org.vedruna.apitwitter1.persistance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedruna.apitwitter1.persistance.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    
    Page<Publication> findPulicationsByUserAuthor_UserId(Integer userId, Pageable pageable);
}
