package com.tadinhos.fitclass.controller;

import com.tadinhos.fitclass.domain.gymowner.GymOwnerService;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreateRequest;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreated;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gym-owner")
public class GymOwnerController {
    @Autowired
    private GymOwnerService gymOwnerService;

    @PostMapping
    @Transactional
    public ResponseEntity<DataGymOwnerCreated> save (@RequestBody DataGymOwnerCreateRequest dataGymOwnerCreateRequest) {
        var gymOwnerCreated = gymOwnerService.create(dataGymOwnerCreateRequest);

        return ResponseEntity.ok().body(gymOwnerCreated);
    }
}
