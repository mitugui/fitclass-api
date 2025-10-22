package com.tadinhos.fitclass.domain.gymowner.dto;

import com.tadinhos.fitclass.domain.address.Address;

import java.time.LocalDate;

public record DataGymOwnerCreate(
        String name,
        String email,
        String password,
        String phoneNumber,
        String cpf,
        char gender,
        LocalDate birthDate,

        Address address) {
    public DataGymOwnerCreate(DataGymOwnerCreateRequest request, Address address) {
        this(
                request.name(),
                request.email(),
                request.password(),
                request.phoneNumber(),
                request.cpf(),
                request.gender().charAt(0),
                request.birthDate(),
                address
        );
    }
}
