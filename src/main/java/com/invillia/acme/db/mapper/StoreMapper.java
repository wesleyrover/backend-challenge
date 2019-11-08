package com.invillia.acme.db.mapper;

import com.invillia.acme.db.dto.StoreDto;
import com.invillia.acme.db.entity.Store;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StoreMapper {

    public static StoreDto convertFrom(Store store){
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .address(AddressMapper.convertFrom(store.getAddress()))
                .build();
    }

    public static Store convertTo(StoreDto storeDto){
        return Store.builder()
                .id(storeDto.getId())
                .name(storeDto.getName())
                .address(AddressMapper.convertTo(storeDto.getAddress()))
                .build();
    }

    public static List<StoreDto> convertFrom(List<Store> addressList){
        return addressList.stream().filter(Objects::nonNull)
                .map(StoreMapper::convertFrom).collect(Collectors.toList());
    }

    public static List<Store> convertTo(List<StoreDto> addressList){
        return addressList.stream().filter(Objects::nonNull)
                .map(StoreMapper::convertTo).collect(Collectors.toList());
    }
}
