package com.hero_associatition.services.Auth;

import com.hero_associatition.config.CustomProperties;
import com.hero_associatition.dto.LoginResponse;
import com.hero_associatition.exceptions.AuthenticationError;
import com.hero_associatition.models.User;
import com.hero_associatition.models.enumerations.Role;
import com.hero_associatition.repositories.UserRepository;
import com.hero_associatition.security.JWTUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by markoreljic on 6.12.16..
 */
@Service
public class AuthenticationService {

    @Inject
    private UserRepository userRepository;

    @Inject
    CustomProperties customProperties;

    @Inject
    PasswordEncoder passwordEncoder;

    public LoginResponse login( String email, String password) throws Exception {
        final Optional<User> optionalUser = this.userRepository.findByEmailPresent(email);

        if(optionalUser == null){
            throw new Exception();
        }
        final User user = this.userRepository.findByEmail(email);

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new Exception();

        final LoginResponse response = new LoginResponse();
        final String accessToken = JWTUtils.createToken(user.getId(), user.getRole(), customProperties.getSecretKey());
        response.setAccessToken(accessToken);
        response.setName(user.getName());
        response.setAlias(user.getAlias());
        response.setLocation(user.getLocation());
        response.setAge(user.getAge());
        response.setId(user.getId());
        response.setRole(user.getRole());

        return response;

    }


    public LoginResponse register( String email, String name, String alias, String race, Integer age, String location, String password ) throws  Exception{

        final Optional<User> optionalUser = this.userRepository.findByEmailPresent(email);

        if(optionalUser == null){
            throw new Exception();
        }
        final User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setAlias(alias);
        user.setRace(race);
        user.setAge(age);
        user.setLocation(location);
        user.setLevel(1);
        user.setExperience(0);
        user.setGold(100);
        user.setRole(Role.ROLE_HERO);
        user.setPassword(passwordEncoder.encode(password));
        user.setAttack(5);
        user.setDefense(5);
        user.setAgility(5);
        user.setLuck(5);
        userRepository.save(user);

        return null;
    }



}
