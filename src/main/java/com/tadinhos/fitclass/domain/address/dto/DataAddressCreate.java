package com.tadinhos.fitclass.domain.address.dto;

import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreateRequest;

public record DataAddressCreate(
        String street,
        String cep,
        String number,
        String neighborhood,
        String town,
        String province) {
    public DataAddressCreate(DataGymOwnerCreateRequest gymOwnerCreateData) {
        this(
            gymOwnerCreateData.street(),
            gymOwnerCreateData.cep(),
            gymOwnerCreateData.number(),
            gymOwnerCreateData.neighborhood(),
            gymOwnerCreateData.town(),
            gymOwnerCreateData.province()
        );
    }
}
