package com.tadinhos.fitclass.domain.gymowner;

import com.tadinhos.fitclass.domain.address.Address;
import com.tadinhos.fitclass.domain.address.AddressRepository;
import com.tadinhos.fitclass.domain.address.dto.DataAddressCreate;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreate;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GymOwnerService {
    @Autowired
    private GymOwnerRepository gymOwnerRepository;
    @Autowired
    private AddressRepository addressRepository;

    public GymOwner create(DataGymOwnerCreateRequest request) {
        var address = createAddress(request);

        var gymOwnerData = new DataGymOwnerCreate(request, address);

        try {
            return gymOwnerRepository.save(new GymOwner(gymOwnerData));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Erro ao salvar GymOwner", e
            );
        }
    }

    private Address createAddress(DataGymOwnerCreateRequest request) {
        var dataAddressCreate = new DataAddressCreate(request);

        try {
            return addressRepository.save(new Address(dataAddressCreate));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Erro ao salvar endereço", e
            );
        }
    }
}
