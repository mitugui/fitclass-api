package com.tadinhos.fitclass.domain.gymowner.dto;

import java.time.LocalDate;

public record DataGymOwnerCreateRequest(
        String name,
        String email,
        String password,
        String phoneNumber,
        String cpf,
        String gender,
        LocalDate birthDate,

        String street,
        String cep,
        String number,
        String neighborhood,
        String town,
        String province) {
}
