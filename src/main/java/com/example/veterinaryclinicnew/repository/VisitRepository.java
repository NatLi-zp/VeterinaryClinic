package com.example.veterinaryclinicnew.repository;

import com.example.veterinaryclinicnew.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Optional<Visit> findById(Integer id);
}
