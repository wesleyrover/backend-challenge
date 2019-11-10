package com.invillia.acme.auth.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum PaymentStatusEnum {
    PROCESSED(1L, "Criação"),
    REFUND(2L, "Reembolso"),
    FINISHED(3L, "Finalizado");

    private Long code;
    private String description;

    public static PaymentStatusEnum getByCode(Long code) {
        return Stream
                .of(values())
                .filter(paymentStatusEnum -> paymentStatusEnum.code.equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
