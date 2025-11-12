package com.tadinhos.fitclass.domain.gymowner.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DataGymOwnerCreateRequest(
        String name,
        String email,
        String password,
        String phoneNumber,
        String cpf,
        String gender,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,

        String street,
        String cep,
        String number,
        String neighborhood,
        String town,
        String province) {
}
