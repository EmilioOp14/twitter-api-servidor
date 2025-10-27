package org.vedruna.apitwitter1.persistance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.vedruna.apitwitter1.persistance.model.Follow;
import org.vedruna.apitwitter1.persistance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer>{


    @Query("""
    SELECT f.following 
    FROM Follow f 
    WHERE f.follower.username = :username
""")
Page<User> findAllFollowingByUsername(@Param("username") String username, Pageable pageable);

    @Query("""
    SELECT f.follower 
    FROM Follow f 
    WHERE f.following.username = :username
""")
Page<User> findAllFollowersByUsername(@Param("username") String username, Pageable pageable);

}
