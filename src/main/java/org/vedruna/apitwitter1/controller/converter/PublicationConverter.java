package org.vedruna.apitwitter1.controller.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vedruna.apitwitter1.controller.dto.PublicationDto;
import org.vedruna.apitwitter1.persistance.model.Publication;

@Mapper(componentModel = "spring")
public interface PublicationConverter {
    
    @Mapping(target = "userAuthor", source = "publication.userAuthor")
    PublicationDto toDto(Publication publication);

    // DTO -> Entity (creación o update controlado desde servicio)
    @Mapping(target = "publicationId", ignore = true)       // el id lo pone la BD
    @Mapping(target = "userAuthor", ignore = true)          // lo establece el servicio según el username
    @Mapping(target = "creationDateTime", ignore = true)    // lo pone Hibernate/BD
    @Mapping(target = "editDateTime", ignore = true)        // lo pone Hibernate en update
    Publication toEntity(PublicationDto publicationDto);
}
