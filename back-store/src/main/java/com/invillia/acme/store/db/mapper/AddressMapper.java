package com.invillia.acme.store.db.mapper;

import com.invillia.acme.store.db.dto.AddressDto;
import com.invillia.acme.store.db.entity.Address;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddressMapper {

    public static AddressDto convertFrom(Address address){
        return Objects.nonNull(address) ?
                AddressDto.builder()
                .id(address.getId())
                .city(address.getCity())
                .complement(address.getComplement())
                .neighborhood(address.getNeighborhood())
                .number(address.getNumber())
                .place(address.getPlace())
                .state(address.getState())
                .zipcode(address.getZipcode())
                .build() : null;
    }

    public static Address convertTo(AddressDto addressDto){
        return Objects.nonNull(addressDto) ? Address.builder()
                .id(addressDto.getId())
                .city(addressDto.getCity())
                .complement(addressDto.getComplement())
                .neighborhood(addressDto.getNeighborhood())
                .number(addressDto.getNumber())
                .place(addressDto.getPlace())
                .state(addressDto.getState())
                .zipcode(addressDto.getZipcode())
                .build() : null;
    }

    public static List<AddressDto> convertFrom(List<Address> addressList){
        return addressList.stream().filter(Objects::nonNull)
                .map(AddressMapper::convertFrom).collect(Collectors.toList());
    }

    public static List<Address> convertTo(List<AddressDto> addressList){
        return addressList.stream().filter(Objects::nonNull)
                .map(AddressMapper::convertTo).collect(Collectors.toList());
    }
}
