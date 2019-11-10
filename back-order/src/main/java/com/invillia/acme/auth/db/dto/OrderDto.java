package com.invillia.acme.auth.db.dto;

import com.invillia.acme.auth.db.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private java.lang.String id;

    @NotEmpty
    private String address;

    @NotNull
    private LocalDateTime dateConfirmation;

    @NotNull
    private OrderStatusEnum status;

    @Valid
    @NotNull
    @Size(min = 1)
    private List<OrderItemDTO> items;
}
