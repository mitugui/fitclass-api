package com.tadinhos.fitclass.domain.gymowner;

import com.tadinhos.fitclass.domain.address.Address;
import com.tadinhos.fitclass.domain.address.dto.DataAddressCreate;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreate;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreateRequest;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GymOwnerService {
    @Autowired
    private GymOwnerRepository gymOwnerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DataGymOwnerCreated create(DataGymOwnerCreateRequest request) {
        var address = new Address(new DataAddressCreate(request));

        var encodedPassword = passwordEncoder.encode(request.password());

        var dataCreate = new DataGymOwnerCreate(
                request.name(),
                request.email(),
                encodedPassword,
                request.phoneNumber(),
                request.cpf(),
                request.gender().charAt(0),
                request.birthDate(),
                address
        );

        var gymOwner = new GymOwner(dataCreate);

        try {
            return new DataGymOwnerCreated(gymOwnerRepository.save(gymOwner));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Erro ao salvar GymOwner", e
            );
        }
    }
}
