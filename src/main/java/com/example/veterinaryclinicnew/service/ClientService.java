package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.dto.ClientDto;
import com.example.veterinaryclinicnew.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    Client getClientById(Integer id);

    List<ClientDto> getAllClients();

    ClientDto createClients(ClientDto newClient);

    ClientDto updateClients(ClientDto updClient);

    void deleteClients(Integer id);
}
