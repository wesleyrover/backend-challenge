package com.invillia.acme.order.repository;

import com.invillia.acme.order.db.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, String> {
}
