package com.invillia.acme.order.db.entity;


import com.invillia.acme.order.db.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends EntityBase implements Serializable {

    private static final long serialVersionUID = -7826318686009712603L;

    @NotEmpty
    @Column(nullable = false)
    private String address;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dateConfirmation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatusEnum status;

    @Size(min = 1)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;
}
