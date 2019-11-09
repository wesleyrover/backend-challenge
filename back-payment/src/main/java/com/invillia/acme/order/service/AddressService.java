package com.invillia.acme.store.service;

import com.invillia.acme.store.db.entity.Address;
import com.invillia.acme.store.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address, AddressRepository> {

}
