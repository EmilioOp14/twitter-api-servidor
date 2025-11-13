package org.vedruna.apitwitter1.persistance.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "publications")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publication_id")
    Integer publicationId;

    @Column(name = "text", nullable = false, length = 500)
    String publicationText;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    LocalDateTime creationDateTime;

    @UpdateTimestamp
    @Column(name = "edit_date")
    LocalDateTime editDateTime;

    // Relación: muchas publicaciones pertenecen a un usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User userAuthor;
}
