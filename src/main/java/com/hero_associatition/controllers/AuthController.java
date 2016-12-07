package com.hero_associatition.controllers;

import com.hero_associatition.dto.LoginRequest;
import com.hero_associatition.dto.LoginResponse;
import com.hero_associatition.services.Auth.AuthenticationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by markoreljic on 6.12.16..
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Inject
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<LoginResponse> signIn( @Valid @RequestBody LoginRequest request) throws Exception {

        final LoginResponse response = authenticationService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok().body(response);
    }
}
