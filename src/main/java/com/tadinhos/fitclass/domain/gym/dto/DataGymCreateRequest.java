package com.tadinhos.fitclass.domain.gym.dto;

public record DataGymCreateRequest (
        String name,
        String cnpj,
        String phoneNumber,

        Long gymOwnerId,

        String street,
        String cep,
        String number,
        String neighborhood,
        String town,
        String province) {
}
