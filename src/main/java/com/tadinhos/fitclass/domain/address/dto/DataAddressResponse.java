package com.tadinhos.fitclass.domain.address.dto;

import com.tadinhos.fitclass.domain.address.Address;

public record DataAddressResponse(
        String street,
        String cep,
        String number,
        String neighborhood,
        String town,
        String province) {
    public DataAddressResponse(Address address) {
        this(
            address.getStreet(),
            address.getCep(),
            address.getNumber(),
            address.getNeighborhood(),
            address.getTown(),
            address.getProvince()
        );
    }
}
