package org.vedruna.apitwitter1.persistance.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements UserDetails{
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

    @Column(name = "description", nullable = false, unique = true)
    String description;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    Rol userRol;

    // Relación inversa: un usuario tiene muchas publicaciones
    @OneToMany(mappedBy = "userAuthor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Publication> publications;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Follow> followingList; // Usuarios a los que sigue

@OneToMany(mappedBy = "following", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Follow> followersList; // Usuarios que lo siguen

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
}
}
