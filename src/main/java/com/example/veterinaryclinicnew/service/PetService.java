package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.dto.PetDto;
import com.example.veterinaryclinicnew.entity.Pet;

import java.util.List;

public interface PetService {
    Pet getPetById(Integer id);

    List<Pet> getAllPets();

    boolean createPets(PetDto newPet);

    PetDto updatePets(PetDto updPet);
}
