package com.invillia.acme.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invillia.acme.order.db.dto.OrderDto;
import com.invillia.acme.order.db.dto.OrderItemDTO;
import com.invillia.acme.order.db.enums.OrderStatusEnum;
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

    String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjbGllbnRlIiwicm9sZXMiOiJST0xFX1VTRVIiLCJleHAiOjE1NzQyOTk5NTF9.gVMeopHPnfdAixFZTHyTUqf-MXNi9Geb4gvvDBq8RcCL2yFGyAKfC0VPohMCHwBao28ErrmVv-Bs-1vzBP1mdQ";

    @Test
    public void save() throws Exception {
        OrderDto orderDTO = OrderDto.builder().address("endereco").dateConfirmation(LocalDateTime.now()).status(OrderStatusEnum.CREATE).build();
        OrderItemDTO orderItemDTO = OrderItemDTO.builder().description("item").amount(1).value(new BigDecimal(11.00)).build();
        List<OrderItemDTO> items = new ArrayList<OrderItemDTO>();
        items.add(orderItemDTO);
        orderDTO.setItems(items);
        mockMvc.perform(post("/orders/save").contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", token)
                .content(objectMapper.writeValueAsString(orderDTO))
                .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());
    }

}