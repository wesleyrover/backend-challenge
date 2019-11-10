package com.invillia.acme.payment.db.mapper;


import com.invillia.acme.payment.db.entity.Payment;
import com.invillia.acme.payment.db.dto.PaymentDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PaymentMapper {

    public static PaymentDto convertFrom(Payment payment) {
        return Objects.nonNull(payment) ?
                PaymentDto.builder()
                        .id(payment.getId())
                        .numberCard(payment.getNumberCard())
                        .idOrder(payment.getIdOrder())
                        .build() : null;
    }

    public static Payment convertTo(PaymentDto paymentDto) {
        Payment payment = Objects.nonNull(paymentDto) ? Payment.builder()
                .numberCard(paymentDto.getNumberCard())
                .idOrder(paymentDto.getIdOrder())
                .build() : null;

        if (Objects.nonNull(payment)) {
            payment.setId(paymentDto.getId());
        }
        return payment;
    }

    public static List<PaymentDto> convertFrom(List<Payment> paymentList) {
        return paymentList.stream().filter(Objects::nonNull)
                .map(PaymentMapper::convertFrom).collect(Collectors.toList());
    }

    public static List<Payment> convertTo(List<PaymentDto> paymentDtoList) {
        return paymentDtoList.stream().filter(Objects::nonNull)
                .map(PaymentMapper::convertTo).collect(Collectors.toList());
    }
}
