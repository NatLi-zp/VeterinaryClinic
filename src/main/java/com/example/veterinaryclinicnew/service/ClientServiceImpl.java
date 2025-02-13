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
    public Client getClientById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) {
            throw new ClientDoesntExistException(ClientErrorMessage.CLIENT_NOT_EXIST);
        }
        System.out.println("Client: " + optionalClient.get());
        Client client = optionalClient.get();
        return client;
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clientsEntities = clientRepository.findAll();
        return clientsEntities.stream()
                .map(entity -> new ClientDto(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }


    @Override
    public ClientDto createClients(ClientDto newClient) {
        Client createClientEntity = new Client(null, newClient.getName());
        Client returnClient = clientRepository.save(createClientEntity);
        return new ClientDto(returnClient.getId(), returnClient.getName());
    }

    @Override
    public ClientDto updateClients(ClientDto updClient) {
        Client updateClientEntity = new Client(updClient.getId(), updClient.getName());
        Client returnClient = clientRepository.save(updateClientEntity);

        // трансформируем данные из Entity в Dto и возвращаем пользователю
        return new ClientDto(returnClient.getId(), returnClient.getName());
    }

    @Override
    public void deleteClients(Integer id) {
        // 1й вариант реализации метода delete, менее информативно
        clientRepository.deleteById(id);

//        // 2й вариант реализации метода delete c предварит. поиском
//        Client clients = clientRepository.findById(id).orElse(null);
//        System.out.println("--------------------------------------------"+"clients: "+clients);
//        if (clients == null) {
//            throw new RuntimeException("Нет такого объекта с Id: " + id);
//        } else {
//            clientRepository.delete(clients);
//        }
    }

}
