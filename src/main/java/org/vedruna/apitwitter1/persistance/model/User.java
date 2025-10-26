package org.vedruna.apitwitter1.persistance.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    Integer userId;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "username", nullable = false, unique = true)
    String username;

    @Column(name = "password", nullable = false)
    String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_rol_id", referencedColumnName = "rol_id", nullable = false)
    Rol userRol;

    // Relación inversa: un usuario tiene muchas publicaciones
    @OneToMany(mappedBy = "userAuthor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Publication> publications;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Follow> followingList; // Usuarios a los que sigue

@OneToMany(mappedBy = "following", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Follow> followersList; // Usuarios que lo siguen
}
