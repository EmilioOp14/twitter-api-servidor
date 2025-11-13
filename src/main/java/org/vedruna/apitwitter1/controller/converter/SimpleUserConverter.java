package org.vedruna.apitwitter1.controller.converter;


import org.mapstruct.*;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;
import org.vedruna.apitwitter1.persistance.model.User;
import org.vedruna.apitwitter1.security.auth.model.LoginRequest;
import org.vedruna.apitwitter1.security.auth.model.RegisterRequest;


@Mapper(componentModel = "spring")
public interface SimpleUserConverter {

    // Convierte de entidad User a DTO
    SimpleUserDto toDto(User user);

    // Convierte de DTO a entidad User
    @InheritInverseConfiguration
    @Mapping(target = "userRol", ignore = true) // Evitamos ciclos o errores si no se incluye el rol completo
    @Mapping(target = "publications", ignore = true)
    @Mapping(target = "followingList", ignore = true)
    @Mapping(target = "followersList", ignore = true)
    User toEntity(SimpleUserDto dto);


    User loginToEntity(LoginRequest dto);

    User registerToEntity(RegisterRequest dto);
}

