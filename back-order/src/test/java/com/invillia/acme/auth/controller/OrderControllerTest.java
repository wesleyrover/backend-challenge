package com.invillia.acme.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invillia.acme.auth.db.dto.OrderDto;
import com.invillia.acme.auth.db.dto.OrderItemDTO;
import com.invillia.acme.auth.db.enums.OrderStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void save() throws Exception {
        OrderDto orderDTO = OrderDto.builder().address("endereco").dateConfirmation(LocalDateTime.now()).status(OrderStatusEnum.CREATE).build();
        OrderItemDTO orderItemDTO = OrderItemDTO.builder().description("item").amount(1).value(new BigDecimal(11.00)).build();
        List<OrderItemDTO> items = new ArrayList<OrderItemDTO>();
        items.add(orderItemDTO);
        orderDTO.setItems(items);
        mockMvc.perform(post("/orders/save").contentType(MediaType.APPLICATION_JSON)
                //  .header("Authorization", token)
                .content(objectMapper.writeValueAsString(orderDTO))
                .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());
    }

//    @Test
//    public void saveSemEndereco() throws Exception {
//        StoreDto storeDTO = StoreDto.builder()
//                .name("Store - Teste - demo")
//                .build();
//        mockMvc.perform(post("/stores/save").contentType(MediaType.APPLICATION_JSON)
//                //  .header("Authorization", token)
//                .content(objectMapper.writeValueAsString(storeDTO))
//                .header("Content-Type", "application/json"))
//                .andExpect(status().isCreated());
//    }
//
//
    @Test
    public void update() throws Exception {
//        StoreDto storeDTO = StoreDto.builder()
//                .id("A")
//                .name("Store - Teste")
//                .build();
//        mockMvc.perform(post("/stores/save").contentType(MediaType.APPLICATION_JSON)
//                //  .header("Authorization", token)
//                .content(objectMapper.writeValueAsString(storeDTO))
//                .header("Content-Type", "application/json"))
//                .andExpect(status().isCreated());
//        storeDTO.setName("Store - Teste - demo");
//        mockMvc.perform(put("/stores/update/A").contentType(MediaType.APPLICATION_JSON)
//                //  .header("Authorization", token)
//                .content(objectMapper.writeValueAsString(storeDTO))
//                .header("Content-Type", "application/json"))
//                .andExpect(status().isOk());
    }
//
//    @Test
//    public void getStore() throws Exception {
//        mockMvc.perform(get("/stores/find").contentType(MediaType.APPLICATION_JSON)
//                // .header("Authorization", token)
//                .header("Content-Type", "application/json"))
//                .andExpect(status().isOk());
//    }
}