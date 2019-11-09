package com.invillia.acme.store.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invillia.acme.store.db.dto.AddressDto;
import com.invillia.acme.store.db.dto.StoreDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void save() throws Exception {
        StoreDto storeDTO = StoreDto.builder()
                .name("Store - Teste - demo")
                .address(AddressDto.builder()
                        .place("Rua Silveira Martins")
                        .complement("Apto 101, edf Humailta")
                        .number(95)
                        .neighborhood("Cabula")
                        .city("Salvador")
                        .zipcode("41150-001")
                        .state("Bahia")
                        .build())
                .build();
        mockMvc.perform(post("/stores/save").contentType(MediaType.APPLICATION_JSON)
                //  .header("Authorization", token)
                .content(objectMapper.writeValueAsString(storeDTO))
                .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());
    }

    @Test
    public void saveSemEndereco() throws Exception {
        StoreDto storeDTO = StoreDto.builder()
                .name("Store - Teste - demo")
                .build();
        mockMvc.perform(post("/stores/save").contentType(MediaType.APPLICATION_JSON)
                //  .header("Authorization", token)
                .content(objectMapper.writeValueAsString(storeDTO))
                .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());
    }


    @Test
    public void update() throws Exception {
        StoreDto storeDTO = StoreDto.builder()
                .id("A")
                .name("Store - Teste")
                .build();
        mockMvc.perform(post("/stores/save").contentType(MediaType.APPLICATION_JSON)
                //  .header("Authorization", token)
                .content(objectMapper.writeValueAsString(storeDTO))
                .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());
        storeDTO.setName("Store - Teste - demo");
        mockMvc.perform(put("/stores/update/A").contentType(MediaType.APPLICATION_JSON)
                //  .header("Authorization", token)
                .content(objectMapper.writeValueAsString(storeDTO))
                .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void getStore() throws Exception {
        mockMvc.perform(get("/stores/find").contentType(MediaType.APPLICATION_JSON)
               // .header("Authorization", token)
                .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }
}