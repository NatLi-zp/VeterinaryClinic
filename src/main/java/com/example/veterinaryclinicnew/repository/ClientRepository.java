package com.example.veterinaryclinicnew.repository;

import com.example.veterinaryclinicnew.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findById(int id);
}
