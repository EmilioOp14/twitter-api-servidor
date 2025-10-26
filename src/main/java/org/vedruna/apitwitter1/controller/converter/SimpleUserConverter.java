package org.vedruna.apitwitter1.controller.converter;


import org.mapstruct.*;
import org.vedruna.apitwitter1.controller.dto.SimpleUserDto;
import org.vedruna.apitwitter1.persistance.model.User;


@Mapper(componentModel = "spring")
public interface SimpleUserConverter {

    // Convierte de entidad User a DTO
    @Mapping(target = "roleName", source = "userRol.rolName")
    SimpleUserDto toDto(User user);

    // Convierte de DTO a entidad User
    @InheritInverseConfiguration
    @Mapping(target = "userRol", ignore = true) // Evitamos ciclos o errores si no se incluye el rol completo
    @Mapping(target = "publications", ignore = true)
    @Mapping(target = "followingList", ignore = true)
    @Mapping(target = "followersList", ignore = true)
    User toEntity(SimpleUserDto dto);
}

