package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.entity.Visit;

import java.util.List;

public interface VisitService {

    Visit getVisitById(int id);

    List<Visit> getAllVisits();

    boolean createVisits(Visit newVisit);

    Visit updateVisits(Visit updVisit);

    void deleteVisits(int id);
}
