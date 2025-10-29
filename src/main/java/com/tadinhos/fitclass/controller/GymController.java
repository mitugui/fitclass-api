package com.tadinhos.fitclass.controller;

import com.tadinhos.fitclass.domain.gym.GymService;
import com.tadinhos.fitclass.domain.gym.dto.DataGymCreateRequest;
import com.tadinhos.fitclass.domain.gym.dto.DataGymCreated;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gym")
public class GymController {
    @Autowired
    private GymService gymService;

    @PostMapping
    @Transactional
    public ResponseEntity<DataGymCreated> save(@RequestBody DataGymCreateRequest dataGymCreateRequest) {
        var gymCreated = gymService.create(dataGymCreateRequest);

        return ResponseEntity.ok(gymCreated);
    }
}
