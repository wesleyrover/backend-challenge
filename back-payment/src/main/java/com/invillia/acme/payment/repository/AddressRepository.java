package com.invillia.acme.store.repository;

import com.invillia.acme.store.db.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, String>{
}
