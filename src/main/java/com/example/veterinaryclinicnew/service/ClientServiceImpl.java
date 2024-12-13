package com.example.veterinaryclinicnew.service;

import com.example.veterinaryclinicnew.dto.ClientDto;
import com.example.veterinaryclinicnew.entity.Client;
import com.example.veterinaryclinicnew.exeption.ClientDoesntExistException;
import com.example.veterinaryclinicnew.exeption.error_messages.ClientErrorMessage;
import com.example.veterinaryclinicnew.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    public final ClientRepository clientRepository;

    @Override
    public Client getClientById(int id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) {
            throw new ClientDoesntExistException(ClientErrorMessage.CLIENT_NOT_EXIST);
        }
        System.out.println("Client: " + optionalClient.get());
        Client client = optionalClient.get();
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clientsEntities = clientRepository.findAll();
        return clientsEntities.stream()
                //       .map(entity -> new Client(entity.getId(), entity.getName(), entity.getPet(), entity.getVisit()))
                .map(entity -> new Client(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }


    @Override
    public ClientDto createClients(ClientDto newClient) {
        //Client createClientEntity = new Client(0, newClient.getName(), newClient.getPet(), newClient.getVisit());
        Client createClientEntity = new Client(); //null, newClient.getName());
        createClientEntity.setName(newClient.getName());
        createClientEntity.setId(100);
        Client returnClient = clientRepository.save(createClientEntity);
        //return returnClient;
        //return new ClientDto(returnClient.getId(), returnClient.getName());
        ClientDto clientDto = new ClientDto();
        clientDto.setName(returnClient.getName());
        return clientDto;
    }

    @Override
    public ClientDto updateClients(ClientDto updClient) {
        // Client updateClientEntity = new Client(updClient.getId(), updClient.getName(), updClient.getPet(), updClient.getVisit());
     //   Client updateClientEntity = new Client(updClient.getId(), updClient.getName());
        Client updateClientEntity = new Client();
        updateClientEntity.setName(updClient.getName());

        Client returnClient = clientRepository.save(updateClientEntity);
//
//        // трансформируем данные из Entity в Dto и возвращаем пользователю
       // return new ClientDto(returnClient.getId(), returnClient.getName());
        ClientDto clientDto = new ClientDto();
        clientDto.setName(returnClient.getName());
        return clientDto;
//        return returnClient;
    }

    @Override
    public void deleteClients(int id) {
        // 1й вариант реализации метода delete, менее информативно
        clientRepository.deleteById(id);

//        // 2й вариант реализации метода delete c предварит. поиском
//        Client clients = clientRepository.findById(id).orElse(null);
//        if (clients == null) {
//            throw new RuntimeException("Нет такого объекта с Id: " + id);
//        } else {
//            clientRepository.delete(clients);
//        }
    }

}
