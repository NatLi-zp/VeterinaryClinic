package com.example.veterinaryclinicnew.repository;

import com.example.veterinaryclinicnew.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    Optional<Pet> findById(int id);

    }
