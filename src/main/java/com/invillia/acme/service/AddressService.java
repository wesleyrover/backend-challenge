package com.invillia.acme.service;

import com.invillia.acme.db.entity.Address;
import com.invillia.acme.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address, AddressRepository> {

}
