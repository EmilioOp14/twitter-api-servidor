package org.vedruna.apitwitter1.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedruna.apitwitter1.persistance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
