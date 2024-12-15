package com.example.veterinaryclinicnew.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitDto {

    private Integer id;

    private LocalDateTime date;

    private String comment;

    private ClientDto client;

    private PetDto pet;

}
