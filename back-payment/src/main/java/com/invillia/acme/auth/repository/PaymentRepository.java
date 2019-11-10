package com.invillia.acme.auth.repository;

import com.invillia.acme.auth.db.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentRepository  extends JpaRepository<Payment, String>, JpaSpecificationExecutor<Payment> {
}
