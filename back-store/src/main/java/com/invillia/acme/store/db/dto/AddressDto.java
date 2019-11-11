package com.invillia.acme.store.db.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private java.lang.String id;
    private java.lang.String place;
    private java.lang.String complement;
    private java.lang.Integer number;
    private java.lang.String neighborhood;
    private java.lang.String city;
    private java.lang.String zipcode;
    private java.lang.String state;
}
