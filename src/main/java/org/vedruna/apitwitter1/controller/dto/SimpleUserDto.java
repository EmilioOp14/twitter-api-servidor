package org.vedruna.apitwitter1.controller.dto;

import lombok.Data;


@Data
public class SimpleUserDto {
    Integer userId;
    String email;
    String username;

    // Opcional: IDs de publicaciones o seguidores (para evitar anidación profunda)
    // private List<Integer> publicationIds;
    // private List<Integer> followingIds;
    // private List<Integer> followerIds;
}
