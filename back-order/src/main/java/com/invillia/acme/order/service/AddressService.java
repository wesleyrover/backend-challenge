package com.invillia.acme.order.service;

import com.invillia.acme.order.db.entity.Address;
import com.invillia.acme.order.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address, AddressRepository> {

}
