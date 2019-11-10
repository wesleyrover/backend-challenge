package com.invillia.acme.auth.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDEM-ITEM")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends EntityBase implements Serializable {

    private static final long serialVersionUID = 5880021267260496495L;

    @JsonIgnoreProperties("items")
    @ManyToOne(targetEntity=Order.class, fetch=FetchType.LAZY)
    private Order order;

    @NotEmpty
    @Column(nullable = false)
    private String description;

    @NotNull
    @DecimalMin("0.00")
    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Min(1)
    @NotNull
    @Column(nullable = false)
    private Integer amount;
}
