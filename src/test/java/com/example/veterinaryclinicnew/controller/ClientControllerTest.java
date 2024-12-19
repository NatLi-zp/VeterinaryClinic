package com.example.veterinaryclinicnew.controller;

import com.example.veterinaryclinicnew.dto.ClientDto;
import com.example.veterinaryclinicnew.entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.veterinaryclinicnew.service.ClientService;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Sql("/schema.sql")
@Sql("/data.sql")
//@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

//    @MockBean
//    private ClientService clientServiceMock;

    @MockitoBean
    private ClientService clientServiceMock;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getClientById() throws Exception {
        when(clientServiceMock.getClientById(1)).thenReturn(new Client(1, "John Doe"));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(
                                "/client/{id}",
                                1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonAsString = result.getResponse().getContentAsString();

        ClientDto clientDto = mapper.readValue(jsonAsString, ClientDto.class);
        Assertions.assertEquals("John Doe", clientDto.getName());
    }


    @Test
    void getAllClients() throws Exception {
        when(clientServiceMock.getAllClients()).thenReturn(List.of(new ClientDto(1, "Test")));
        this.mockMvc.perform(get("/client"))
                .andDo(print()) //печать лога вызова
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..id").exists())
                .andExpect(jsonPath("$..id").value(1))
                .andExpect(jsonPath("$..name").value("Test"))
        ;

    }

    @Test
    void createClients() throws Exception {
        //   when(clientServiceMock.createClients(any(ClientDto.class))).thenReturn(true); // у Александра
        when(clientServiceMock.createClients(any(ClientDto.class))).thenReturn(new ClientDto(1, "TestName"));
        this.mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "id": null,
                                    "name": "TestName"
                                }
                                """
                        ))
                .andDo(print())
                .andExpect(status().isOk());
        // .andExpect(status().isCreated()); // не работает
    }

    @Test
    void updateClients() throws Exception {
        ClientDto inputClient = new ClientDto(1, "John Doe");
        ClientDto expectedClient = inputClient; // редактирование прошло успешно

        when(clientServiceMock.updateClients(inputClient))
                .thenReturn(new ClientDto(inputClient.getId(), inputClient.getName()));  //.thenReturn(expectedCategory)

        this.mockMvc.perform(put("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputClient))) // jackson: object -> json
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(expectedClient.getId()))
                .andExpect(jsonPath("$.name").value(expectedClient.getName()));
    }

    @Test
    void deleteClients() throws Exception {
        Integer inputId = 1;

        this.mockMvc.perform(delete("/client/{id}", inputId)) ///client/1
                .andDo(print()) //печать лога вызова
                .andExpect(status().isNoContent());

        //return void
        verify(clientServiceMock).deleteClients(inputId);
    }
}