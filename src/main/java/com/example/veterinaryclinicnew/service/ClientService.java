package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.dto.ClientDto;
import com.example.veterinaryclinicnew.entity.Client;

import java.util.List;

public interface ClientService {

    Client getClientById(int id);

    List<Client> getAllClients();

    ClientDto createClients(ClientDto newClient);

    ClientDto updateClients(ClientDto updClient);

    void deleteClients(int id);
}
