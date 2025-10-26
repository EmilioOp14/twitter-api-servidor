package org.vedruna.apitwitter1.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedruna.apitwitter1.persistance.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    // RolRepository
Optional<Rol> findByRolName(String rolName);

}
