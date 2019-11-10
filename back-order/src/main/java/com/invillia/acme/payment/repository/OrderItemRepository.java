package com.invillia.acme.payment.repository;

import com.invillia.acme.payment.db.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, String> {
}
