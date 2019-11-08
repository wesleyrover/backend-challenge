package com.invillia.acme.db.mapper;

import com.invillia.acme.db.dto.AddressDto;
import com.invillia.acme.db.dto.StoreDto;
import com.invillia.acme.db.entity.Store;

public class StoreMapper {

    public static StoreDto convertFrom(Store store){
        return StoreDto.builder()
                .id(store.getId())
                .address(AddressMapper.convertFrom(store.getAddress()))
                .build();
    }

    public static Store convertTo(StoreDto storeDto){
        return Store.builder()
                .id(storeDto.getId())
                .address(AddressMapper.convertTo(storeDto.getAddress()))
                .build();
    }
}
