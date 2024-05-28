package ru.kolokolnin.testntt.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrganizationDto {

    private Integer id;
    private String fullName;
    private String shortName;
    private String inn;
    private String ogrn;
    private String postalAddress;
    private String juridicalAddress;
    private DirectorDto directorInfo;
    private List<FilialOrganizationDto> filialOrganization;
}

