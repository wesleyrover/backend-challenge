package com.invillia.acme.order.db.mapper;

import com.invillia.acme.order.db.dto.OrderItemDTO;
import com.invillia.acme.order.db.entity.OrderItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderItemMapper {

    public static OrderItemDTO convertFrom(OrderItem orderItem) {
        return Objects.nonNull(orderItem) ?
                OrderItemDTO.builder()
                        .id(orderItem.getId())
                        .amount(orderItem.getAmount())
                        .description(orderItem.getDescription())
                        .value(orderItem.getUnitPrice())
                        .build() : null;
    }

    public static OrderItem convertTo(OrderItemDTO orderItemDto) {
        OrderItem orderItem = Objects.nonNull(orderItemDto) ?
                OrderItem.builder()
                        .amount(orderItemDto.getAmount())
                        .unitPrice(orderItemDto.getValue())
                        .description(orderItemDto.getDescription())
                        .build() : null;
        if (Objects.nonNull(orderItem))
            orderItem.setId(orderItem.getId());
        return orderItem;
    }

    public static List<OrderItemDTO> convertFrom(List<OrderItem> addressList) {
        return addressList.stream().filter(Objects::nonNull)
                .map(OrderItemMapper::convertFrom).collect(Collectors.toList());
    }

    public static List<OrderItem> convertTo(List<OrderItemDTO> addressList) {
        return addressList.stream().filter(Objects::nonNull)
                .map(OrderItemMapper::convertTo).collect(Collectors.toList());
    }
}
