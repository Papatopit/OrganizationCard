package ru.kolokolnin.testntt.mapper;

import org.mapstruct.Mapper;
import ru.kolokolnin.testntt.domain.FilialOrganization;
import ru.kolokolnin.testntt.dto.FilialOrganizationDto;

@Mapper(componentModel = "spring")
public interface FilialOrganizationMapper {

    FilialOrganizationDto mapToDto(FilialOrganization filialOrganization);

    FilialOrganization mapToEntity(FilialOrganizationDto filialOrganizationDto);
}
