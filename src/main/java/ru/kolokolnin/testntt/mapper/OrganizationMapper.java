package ru.kolokolnin.testntt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.kolokolnin.testntt.domain.Organization;
import ru.kolokolnin.testntt.dto.OrganizationDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {DirectorMapper.class, FilialOrganizationMapper.class})
public interface OrganizationMapper {


    OrganizationDto organizationToOrganizationDto(Organization organization);

    Organization organizationDtoToOrganization(OrganizationDto organizationDto);

}
