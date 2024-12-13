package com.example.veterinaryclinicnew.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
public class ClientDto {

    private Integer id;

    private String name;

    public ClientDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
