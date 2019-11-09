package com.invillia.acme.order.db.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {

    private java.lang.String id;
    private java.lang.String name;
    private AddressDto address;
}
