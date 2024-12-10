package com.example.veterinaryclinicnew.controller;

import com.example.veterinaryclinicnew.entity.Client;
import com.example.veterinaryclinicnew.entity.Pet;
import com.example.veterinaryclinicnew.service.ClientService;
import com.example.veterinaryclinicnew.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    public final PetService petService;

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable(name = "id") int id) {
        return petService.getPetById(id);
    }

    @GetMapping  //select
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping //Jackson
    public boolean createPets(@RequestBody Pet newPet) { //insert
        return petService.createPets(newPet);
    }
}
