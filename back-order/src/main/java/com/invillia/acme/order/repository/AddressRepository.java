package com.invillia.acme.order.repository;

import com.invillia.acme.order.db.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, String>{
}
