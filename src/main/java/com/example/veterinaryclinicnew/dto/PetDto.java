package com.example.veterinaryclinicnew.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDto {

    public Integer id;

    public String name;

    public ClientDto client;

    public PetDto(Integer id, String name, ClientDto client) {
        this.id = id;
        this.name = name;
        this.client = client;
    }
}
