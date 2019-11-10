package com.invillia.acme.auth.db.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

    private java.lang.String id;

    @NotEmpty
    private String description;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal value;

    @Min(1)
    @NotNull
    private Integer amount;
}
