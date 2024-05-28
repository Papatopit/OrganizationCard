package ru.kolokolnin.testntt.dto;

import lombok.Data;

@Data
public class FilialOrganizationDto {

    private Integer id;
    private String fullName;
    private String postalAddress;
    private DirectorDto directorInfo;
}
