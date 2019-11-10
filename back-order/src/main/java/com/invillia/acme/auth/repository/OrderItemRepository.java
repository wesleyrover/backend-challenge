package com.invillia.acme.auth.repository;

import com.invillia.acme.auth.db.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, String> {
}
