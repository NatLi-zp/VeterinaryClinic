package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.dto.ClientDto;
import com.example.veterinaryclinicnew.dto.VisitDto;
import com.example.veterinaryclinicnew.entity.Visit;

import java.util.List;

public interface VisitService {

    Visit getVisitById(Integer id);

    List<Visit> getAllVisits();

    boolean createVisits(VisitDto newVisit);

    VisitDto updateVisits(VisitDto updVisit);

    void deleteVisits(Integer id);

   }
