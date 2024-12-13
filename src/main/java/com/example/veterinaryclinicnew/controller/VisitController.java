package com.example.veterinaryclinicnew.controller;

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
    public Visit getVisitById(@PathVariable(name = "id") int id) {
        return visitService.getVisitById(id);
    }

    @GetMapping  //select
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @PostMapping
    public boolean createVisits(@RequestBody Visit newVisit) { //insert
        return visitService.createVisits(newVisit);
    }

    @PutMapping
    public Visit updateVisits(@RequestBody Visit updVisit) { //update
        return visitService.updateVisits(updVisit);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteVisits(@PathVariable int id) { //delete
        visitService.deleteVisits(id);
    }
}
