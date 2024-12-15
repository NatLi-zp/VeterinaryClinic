package com.example.veterinaryclinicnew.controller;

import com.example.veterinaryclinicnew.dto.VisitDto;
import com.example.veterinaryclinicnew.entity.Visit;
import com.example.veterinaryclinicnew.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
@RequiredArgsConstructor
public class VisitController {

    public final VisitService visitService;

    // почему так работает странно?
    @GetMapping("/{id}")
    public Visit getVisitById(@PathVariable(name = "id") Integer id) {
        return visitService.getVisitById(id);
    }

    @GetMapping  //select
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @PostMapping
    public boolean createVisits(@RequestBody VisitDto newVisit) { //insert
        return visitService.createVisits(newVisit);
    }

    @PutMapping
    public VisitDto updateVisits(@RequestBody VisitDto updVisit) { //update
        return visitService.updateVisits(updVisit);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteVisits(@PathVariable Integer id) { //delete
        visitService.deleteVisits(id);
    }
}
