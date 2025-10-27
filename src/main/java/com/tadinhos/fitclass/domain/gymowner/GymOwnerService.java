package com.tadinhos.fitclass.domain.gymowner;

import com.tadinhos.fitclass.domain.address.Address;
import com.tadinhos.fitclass.domain.address.dto.DataAddressCreate;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreate;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreateRequest;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GymOwnerService {
    @Autowired
    private GymOwnerRepository gymOwnerRepository;

    public DataGymOwnerCreated create(DataGymOwnerCreateRequest request) {
        var address = new Address(new DataAddressCreate(request));
        var gymOwner = new GymOwner(new DataGymOwnerCreate(request, address));

        try {
            return new DataGymOwnerCreated(gymOwnerRepository.save(gymOwner));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Erro ao salvar GymOwner", e
            );
        }
    }
}
