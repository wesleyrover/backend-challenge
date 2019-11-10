package com.invillia.acme.auth.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum OrderStatusEnum {

    CREATE(1L, "Criação"),
    ACCOMPLISHED(2L, "Realizado"),
    REFUND(3L, "Reembolso");

    private Long code;
    private String description;

    public static OrderStatusEnum getByCode(Long code) {
        return Stream
                .of(values())
                .filter(orderStatusEnum -> orderStatusEnum.code.equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
