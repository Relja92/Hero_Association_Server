package com.hero_associatition.controllers;

import com.hero_associatition.dto.LoginRequest;
import com.hero_associatition.dto.LoginResponse;
import com.hero_associatition.dto.UserDTO;
import com.hero_associatition.exceptions.AuthenticationError;
import com.hero_associatition.models.User;
import com.hero_associatition.services.Auth.AuthenticationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<LoginResponse> login( @Valid @RequestBody LoginRequest request) throws Exception {
        try{
            final LoginResponse response = authenticationService.login(request.getEmail(), request.getPassword());
            return ResponseEntity.ok().body(response);
        } catch(Exception e){
            throw new AuthenticationError("credentials.invalid", "Credentials are invalid!");
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<LoginResponse> signIn( @Valid @RequestBody UserDTO user) throws Exception {
        try{
            final LoginResponse response = authenticationService.register(user.getEmail(),user.getName(), user.getAlias(), user.getRace(), user.getAge(), user.getLocation(),user.getPassword());
            return ResponseEntity.ok().body(response);
        } catch(Exception e){
            throw new Error("Email Already registered");
        }

    }
}
