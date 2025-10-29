package com.tadinhos.fitclass.domain.gym;

import com.tadinhos.fitclass.domain.address.Address;
import com.tadinhos.fitclass.domain.address.dto.DataAddressCreate;
import com.tadinhos.fitclass.domain.gym.dto.DataGymCreate;
import com.tadinhos.fitclass.domain.gym.dto.DataGymCreateRequest;
import com.tadinhos.fitclass.domain.gym.dto.DataGymCreated;
import com.tadinhos.fitclass.domain.gymowner.GymOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GymService {
    @Autowired
    private GymRepository gymRepository;

    @Autowired
    private GymOwnerRepository gymOwnerRepository;

    public DataGymCreated create(DataGymCreateRequest request) {
        var gymOwner = gymOwnerRepository.findById(request.gymOwnerId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Dono da academia não encontrado"
                ));
        var address = new Address(new DataAddressCreate(request));
        var gym = new Gym(new DataGymCreate(request, address, gymOwner));

        try  {
            return new DataGymCreated(gymRepository.save(gym));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Erro ao salvar Gym", e
            );
        }
    }
}
