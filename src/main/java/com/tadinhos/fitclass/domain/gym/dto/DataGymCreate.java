package com.tadinhos.fitclass.domain.gym.dto;

import com.tadinhos.fitclass.domain.address.Address;
import com.tadinhos.fitclass.domain.gymowner.GymOwner;

public record DataGymCreate(
        String name,
        String cnpj,
        String phoneNumber,

        Address address,

        GymOwner gymOwner) {
    public DataGymCreate(DataGymCreateRequest request, Address address, GymOwner gymOwner) {
        this(
                request.name(),
                request.cnpj(),
                request.phoneNumber(),
                address,
                gymOwner);
    }
}
