package com.example.veterinaryclinicnew.controller;

import com.example.veterinaryclinicnew.entity.Client;
import com.example.veterinaryclinicnew.entity.Pet;
import com.example.veterinaryclinicnew.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    public final ClientService clientService;

    // почему так работает странно?
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable(name = "id") int id) {
        return clientService.getClientById(id);
    }

    @GetMapping  //select
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping //Jackson
    public boolean createPets(@RequestBody Client newClient) { //insert
        return clientService.createClients(newClient);
    }

    @PutMapping
    public Client updateClients(@RequestBody Client updClient) { //update
        return clientService.updateClients(updClient);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClients(@PathVariable int id) { //delete
        clientService.deleteClients(id);
    }
}
