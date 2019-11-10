package com.invillia.acme.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invillia.acme.payment.db.dto.PaymentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void save() throws Exception {
        PaymentDto paymentDTO = PaymentDto.builder()
                .numberCard("1234567890123456")
                .idOrder(UUID.randomUUID().toString().toUpperCase())
                .build();
        mockMvc.perform(post("/payments/save").contentType(MediaType.APPLICATION_JSON)
                //  .header("Authorization", token)
                .content(objectMapper.writeValueAsString(paymentDTO))
                .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());
    }

//    @Test
//    public void saveSemEndereco() throws Exception {
//        PaymentDto PaymentDTO = PaymentDto.builder()
//                .name("Payment - Teste - demo")
//                .build();
//        mockMvc.perform(post("/Payments/save").contentType(MediaType.APPLICATION_JSON)
//                //  .header("Authorization", token)
//                .content(objectMapper.writeValueAsString(PaymentDTO))
//                .header("Content-Type", "application/json"))
//                .andExpect(status().isCreated());
//    }
//
//
//    @Test
//    public void update() throws Exception {
//        PaymentDto PaymentDTO = PaymentDto.builder()
//                .id("A")
//                .name("Payment - Teste")
//                .build();
//        mockMvc.perform(post("/Payments/save").contentType(MediaType.APPLICATION_JSON)
//                //  .header("Authorization", token)
//                .content(objectMapper.writeValueAsString(PaymentDTO))
//                .header("Content-Type", "application/json"))
//                .andExpect(status().isCreated());
//        PaymentDTO.setName("Payment - Teste - demo");
//        mockMvc.perform(put("/Payments/update/A").contentType(MediaType.APPLICATION_JSON)
//                //  .header("Authorization", token)
//                .content(objectMapper.writeValueAsString(PaymentDTO))
//                .header("Content-Type", "application/json"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void getPayment() throws Exception {
//        mockMvc.perform(get("/Payments/find").contentType(MediaType.APPLICATION_JSON)
//               // .header("Authorization", token)
//                .header("Content-Type", "application/json"))
//                .andExpect(status().isOk());
//    }
}