package com.hero_associatition.controllers;

import com.hero_associatition.dto.UserDTO;
import com.hero_associatition.models.User;

import com.hero_associatition.repositories.UserRepository;
import com.hero_associatition.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by markoreljic on 1.12.16..
 */
@RestController
@RequestMapping("/users")
public class UserRestController {
    @Inject
    private UserService userService;

    private final UserRepository userRepository;

    public UserRestController( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    Collection<User> getAll(){
        return this.userRepository.findAll();
    }



    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<User> getSingle( @PathVariable Long userId) throws Exception {
        try{
            return ResponseEntity.ok(this.userRepository.findOne(userId));
        }catch (Exception e){
            throw new Exception();
        }

    }

    @RequestMapping(value = "/update/{userId}", method = RequestMethod.PUT, consumes = "application/json")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User updateHero(@RequestBody @Valid User user, @PathVariable Long userId){
        user.setId(userId);
        try {
            userService.editUser(userId, user.getEmail(), user.getName(), user.getAlias(), user.getRace(), user.getAge(), user.getLocation(), user.getLevel(), user.getRank());
        }catch (Exception e){
            throw new Error();
        }
        return user;
    }
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE, consumes = "application/json")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteUser( @PathVariable Long userId) {
        try{
            userService.deleteUser(userId);
        }catch (Exception e){
            throw new Error();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
