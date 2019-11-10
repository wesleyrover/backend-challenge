package com.invillia.acme.payment.db.mapper;

import com.invillia.acme.payment.db.dto.OrderDto;
import com.invillia.acme.payment.db.entity.Order;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDto convertFrom(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .address(order.getAddress())
                .status(order.getStatus())
                .dateConfirmation(order.getDateConfirmation())
                .items(OrderItemMapper.convertFrom(order.getItems()))
                .build();
    }

    public static Order convertTo(OrderDto orderDto){
        Order order = Order.builder()
                .address(orderDto.getAddress())
                .status(orderDto.getStatus())
                .dateConfirmation(orderDto.getDateConfirmation())
                .items(OrderItemMapper.convertTo(orderDto.getItems()))
                .build();
        if (Objects.nonNull(orderDto.getId()))
            order.setId(orderDto.getId());
        return order;
    }

    public static List<OrderDto> convertFrom(List<Order> addressList){
        return addressList.stream().filter(Objects::nonNull)
                .map(OrderMapper::convertFrom).collect(Collectors.toList());
    }

    public static List<Order> convertTo(List<OrderDto> addressList){
        return addressList.stream().filter(Objects::nonNull)
                .map(OrderMapper::convertTo).collect(Collectors.toList());
    }
}
