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

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/schema.sql")
@Sql("/data.sql")
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void getClientById() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(
                                "/client/{id}",
                                1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonAsString = result.getResponse().getContentAsString();

        ClientDto client = mapper.readValue(jsonAsString, ClientDto.class);
        Assertions.assertEquals("John Doe", client.getName());
    }


    @Test
    void getAllClients() {

    }

    @Test
    void createClients() {
    }

    @Test
    void updateClients() {
    }

    @Test
    void deleteClients() {
    }
}