package com.invillia.acme.auth.repository;

import com.invillia.acme.auth.db.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {

}
