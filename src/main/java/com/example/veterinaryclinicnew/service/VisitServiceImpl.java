package com.example.veterinaryclinicnew.service;

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
    public Visit getVisitById(int id) {
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
    public boolean createVisits(Visit newVisit) {
        Visit createVisitEntity = new Visit(0, newVisit.getDate(), newVisit.getComment(), newVisit.getClient(), newVisit.getPet());
        Visit returnVisit = visitRepository.save(createVisitEntity);
        return createVisitEntity.getId() != 0;

    }

    @Override
    public Visit updateVisits(Visit updVisit) {
        Visit updateVisitEntity = new Visit(updVisit.getId(), updVisit.getDate(), updVisit.getComment(), updVisit.getClient(), updVisit.getPet());
        Visit returnVisit = visitRepository.save(updateVisitEntity);
//
//        // трансформируем данные из Entity в Dto и возвращаем пользователю
//        return new Client(returnClient.getId(), returnClient.getName());
        return returnVisit;
    }

    @Override
    public void deleteVisits(int id) {
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
