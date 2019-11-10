package com.invillia.acme.auth.db.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private java.lang.String id;
    private String numberCard;
    private String idOrder;
}
