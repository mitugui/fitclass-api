package com.tadinhos.fitclass.controller;

import com.tadinhos.fitclass.domain.user.User;
import com.tadinhos.fitclass.security.TokenService;
import com.tadinhos.fitclass.security.dto.DataLogin;
import com.tadinhos.fitclass.security.dto.DataTokenJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<DataTokenJWT> login(@RequestBody @Valid DataLogin data) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }
}
