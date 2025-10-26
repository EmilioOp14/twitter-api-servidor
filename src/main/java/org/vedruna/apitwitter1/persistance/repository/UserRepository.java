package org.vedruna.apitwitter1.persistance.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedruna.apitwitter1.persistance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    Page<User> findUserByUsernameStartingWith(String name, Pageable pageable);
    Optional<User> findByUsername(String username);


}
