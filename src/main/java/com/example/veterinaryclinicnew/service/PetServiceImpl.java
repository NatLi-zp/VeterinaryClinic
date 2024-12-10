package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.entity.Pet;
import com.example.veterinaryclinicnew.exeption.PetDoesntExistException;
import com.example.veterinaryclinicnew.exeption.error_messages.PetErrorMessage;
import com.example.veterinaryclinicnew.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    public final PetRepository petRepository;

    @Override
    public Pet getPetById(int id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (!optionalPet.isPresent()) {
            throw new PetDoesntExistException(PetErrorMessage.PET_NOT_EXIST);
        }
        System.out.println("Pet: " + optionalPet.get());
        Pet pet = optionalPet.get();
        return pet;
    }


    @Override
    public boolean createPets(Pet newPet) {
        Pet createPetEntity = new Pet(0, newPet.getName(), newPet.getClient());
        Pet returnPet = petRepository.save(createPetEntity);
        return createPetEntity.getId() != 0;
        //  return createPetEntity.getId()!= null;
        // return returnPet;
    }

    @Override
    public List<Pet> getAllPets() {
        List<Pet> petsEntities = petRepository.findAll();
        return petsEntities.stream()
                .map(entity -> new Pet(entity.getId(), entity.getName(), entity.getClient()))
                .collect(Collectors.toList());
    }
}

