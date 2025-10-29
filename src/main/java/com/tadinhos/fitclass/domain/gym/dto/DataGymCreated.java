package com.tadinhos.fitclass.domain.gym.dto;

import com.tadinhos.fitclass.domain.address.dto.DataAddressResponse;
import com.tadinhos.fitclass.domain.gym.Gym;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreated;

public record DataGymCreated(
        Long id,
        String name,
        String cnpj,
        String phoneNumber,
        DataAddressResponse address,
        DataGymOwnerCreated gymOwner) {
    public DataGymCreated(Gym gym) {
        this(
                gym.getId(),
                gym.getName(),
                gym.getCnpj(),
                gym.getPhoneNumber(),
                new DataAddressResponse(gym.getAddress()),
                new DataGymOwnerCreated(gym.getGymOwner())
        );
    }
}
