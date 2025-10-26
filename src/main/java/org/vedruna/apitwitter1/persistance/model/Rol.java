package org.vedruna.apitwitter1.persistance.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id", nullable = false, unique = true)
    Integer rolId;

    @Column(name = "rol_name", nullable = false, unique = true)
    String rolName;

    @OneToMany(mappedBy = "userRol", 
               cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<User> users;
}
