package ru.kolokolnin.testntt.mapper;

import org.mapstruct.Mapper;
import ru.kolokolnin.testntt.domain.Director;
import ru.kolokolnin.testntt.dto.DirectorDto;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    DirectorDto mapToDto(Director director);

    Director mapToModel(DirectorDto directorDto);
}
