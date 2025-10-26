package org.vedruna.apitwitter1.controller.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vedruna.apitwitter1.controller.dto.PublicationDto;
import org.vedruna.apitwitter1.persistance.model.Publication;

@Mapper(componentModel = "spring")
public interface PublicationConverter {
    
    @Mapping(target = "userAuthor", source = "publication.userAuthor")
    PublicationDto toDto(Publication publication);
}
