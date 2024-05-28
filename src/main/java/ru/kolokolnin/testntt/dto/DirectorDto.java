package ru.kolokolnin.testntt.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DirectorDto {
    private Integer id;
    private String surname;
    private String firstName;
    private String patronymic;
    private LocalDate dateOfBirth;
}
