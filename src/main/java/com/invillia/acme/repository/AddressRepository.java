package com.invillia.acme.repository;

import com.invillia.acme.db.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, String>{
}
