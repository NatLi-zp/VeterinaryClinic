package com.example.veterinaryclinicnew.controller;

import com.example.veterinaryclinicnew.dto.ClientDto;
import com.example.veterinaryclinicnew.entity.Client;
import com.example.veterinaryclinicnew.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    public final ClientService clientService;

    // почему так работает странно?
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable(name = "id") Integer id) {
        return clientService.getClientById(id);
    }

    @GetMapping  //select
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping //Jackson
    public ClientDto createClients(@RequestBody ClientDto newClient) { //insert
        return clientService.createClients(newClient);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public ClientDto updateClients(@RequestBody ClientDto updClient) { //update
        return clientService.updateClients(updClient);
    }

//    @DeleteMapping(value = "/{id}")
//    public void deleteClients(@PathVariable Integer id) { //delete
//        clientService.deleteClients(id);
//    }

    @DeleteMapping(value = "/{id}")//delete
    public ResponseEntity<Void> deleteClients(@PathVariable Integer id) {
        clientService.deleteClients(id);
        return ResponseEntity.noContent().build();
    }


}