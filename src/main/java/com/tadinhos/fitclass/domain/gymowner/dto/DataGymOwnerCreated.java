package com.tadinhos.fitclass.domain.gymowner.dto;

import com.tadinhos.fitclass.domain.address.dto.DataAddressResponse;
import com.tadinhos.fitclass.domain.gymowner.GymOwner;

import java.time.LocalDate;

public record DataGymOwnerCreated(
        String name,
        String email,
        String phoneNumber,
        String cpf,
        char gender,
        LocalDate birthDate,
        DataAddressResponse address) {
    public DataGymOwnerCreated(GymOwner gymOwner) {
        this(
                gymOwner.getName(),
                gymOwner.getEmail(),
                gymOwner.getPhoneNumber(),
                gymOwner.getCpf(),
                gymOwner.getGender(),
                gymOwner.getBirthDate(),
                new DataAddressResponse(gymOwner.getAddress())
        );
    }
}
