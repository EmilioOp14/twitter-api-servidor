package org.vedruna.apitwitter1.persistance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vedruna.apitwitter1.persistance.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    
    Page<Publication> findPulicationsByUserAuthor_UserId(Integer userId, Pageable pageable);

@Query("""
    SELECT p
    FROM Publication p
    WHERE p.userAuthor.username = :username
       OR p.userAuthor.userId IN (
            SELECT f.following.userId
            FROM Follow f
            WHERE f.follower.username = :username
       )
    ORDER BY p.creationDateTime DESC
""")

Page<Publication> findFeedByFollowerUsername(@Param("username") String username, Pageable pageable);

}
