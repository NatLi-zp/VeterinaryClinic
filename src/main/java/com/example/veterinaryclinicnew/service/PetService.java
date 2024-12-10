package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.entity.Pet;

import java.util.List;

public interface PetService {
    Pet getPetById(int id);

    List<Pet> getAllPets();

    boolean createPets(Pet newPet);
}
