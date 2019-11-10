package com.invillia.acme.auth.db.entity;

import com.invillia.acme.auth.db.enums.PaymentStatusEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends EntityBase implements Serializable {

    private static final long serialVersionUID = -3755538234370409779L;

    @NonNull
    private String numberCard;

    @NonNull
    @Column(nullable = false)
    private String idOrder;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatusEnum statusPayment;

    @Column(nullable = true)
    private LocalDateTime dateConfirmation;

    @Column(nullable = true)
    private BigDecimal valueTotal;

    @Column(nullable = true)
    private BigDecimal valueRefund;
}
