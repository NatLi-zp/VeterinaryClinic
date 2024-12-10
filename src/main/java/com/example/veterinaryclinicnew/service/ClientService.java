package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.entity.Client;
import com.example.veterinaryclinicnew.entity.Pet;

import java.util.List;

public interface ClientService {

    Client getClientById(int id);

    List<Client> getAllClients();

    boolean createClients(Client newClient);

    Client updateClients(Client updClient);

    void deleteClients(int id);
}
