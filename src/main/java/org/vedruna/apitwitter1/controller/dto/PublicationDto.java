package org.vedruna.apitwitter1.controller.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PublicationDto {
    Integer publicationId;
    String publicationText;
    LocalDateTime creationDateTime;
    LocalDateTime editDateTime;
    SimpleUserDto userAuthor;
}
