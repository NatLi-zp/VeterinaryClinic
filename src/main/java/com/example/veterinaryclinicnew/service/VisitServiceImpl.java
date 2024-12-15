package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.dto.ClientDto;
import com.example.veterinaryclinicnew.dto.PetDto;
import com.example.veterinaryclinicnew.dto.VisitDto;
import com.example.veterinaryclinicnew.entity.Client;
import com.example.veterinaryclinicnew.entity.Pet;
import com.example.veterinaryclinicnew.entity.Visit;
import com.example.veterinaryclinicnew.exeption.VisitDoesntExistException;
import com.example.veterinaryclinicnew.exeption.error_messages.ClientErrorMessage;
import com.example.veterinaryclinicnew.exeption.error_messages.VisitErrorMessage;
import com.example.veterinaryclinicnew.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    public final VisitRepository visitRepository;

    @Override
    public Visit getVisitById(Integer id) {
        Optional<Visit> optionalVisit = visitRepository.findById(id);
        if (!optionalVisit.isPresent()) {
            throw new VisitDoesntExistException(VisitErrorMessage.VISIT_NOT_EXIST);
        }
        System.out.println("Visit: " + optionalVisit.get());
        Visit visit = optionalVisit.get();
        return visit;
    }

    @Override
    public List<Visit> getAllVisits() {
        List<Visit> visitsEntities = visitRepository.findAll();
        return visitsEntities.stream()
                .map(entity -> new Visit(entity.getId(), entity.getDate(), entity.getComment(), entity.getClient(), entity.getPet()))
                .collect(Collectors.toList());
    }


    @Override
    public boolean createVisits(VisitDto newVisit) {

        Client client = new Client(newVisit.getClient().getId(), newVisit.getClient().getName());
        Pet pet = new Pet(newVisit.getPet().getId(), newVisit.getPet().getName(), client);

        Visit createVisitEntity = new Visit(null, newVisit.getDate(), newVisit.getComment(), client, pet);
        Visit returnVisit = visitRepository.save(createVisitEntity);

        return createVisitEntity.getId() != 0;

    }

    @Override
    public VisitDto updateVisits(VisitDto updVisit) {

        Client client = new Client(updVisit.getClient().getId(), updVisit.getClient().getName());
        Pet pet = new Pet(updVisit.getPet().getId(), updVisit.getPet().getName(), client);

        Visit updateVisitEntity = new Visit(updVisit.getId(), updVisit.getDate(), updVisit.getComment(), client, pet);
        Visit returnVisit = visitRepository.save(updateVisitEntity);

        ClientDto clientDto = new ClientDto(returnVisit.getClient().getId(), returnVisit.getClient().getName());
        PetDto petDto = new PetDto(returnVisit.getPet().getId(), returnVisit.getPet().getName(), clientDto);
        VisitDto visitDto = new VisitDto(returnVisit.getId(), returnVisit.getDate(), returnVisit.getComment(), clientDto, petDto);

        return visitDto;

    }

    @Override
    public void deleteVisits(Integer id) {
        // 1й вариант реализации метода delete, менее информативно
        visitRepository.deleteById(id);

//        // 2й вариант реализации метода delete c предварит. поиском
//        Client clients = clientRepository.findById(id).orElse(null);
//        if (clients == null) {
//            throw new RuntimeException("Нет такого объекта с Id: " + id);
//        } else {
//            clientRepository.delete(clients);
//        }
    }

}
