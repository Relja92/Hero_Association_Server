package com.hero_associatition.services.Auth;

import com.hero_associatition.config.CustomProperties;
import com.hero_associatition.dto.LoginResponse;
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
            throw new Error("Credentials are invalid!");
        }
        final User user = this.userRepository.findByEmail(email);

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new Error("Credentials are invalid!");

        final LoginResponse response = new LoginResponse();
        final String accessToken = JWTUtils.createToken(user.getId(), user.getRole(), customProperties.getSecretKey());
        response.setAccessToken(accessToken);
        response.setName(user.getName());
        response.setAlias(user.getAlias());
        response.setLocation(user.getLocation());
        response.setAge(user.getAge());
        response.setId(user.getId());
        response.setRank(user.getRank());
        response.setRole(user.getRole());
        response.setLevel(user.getLevel());


        return response;

    }


    public LoginResponse register( String email, String name, String alias, String race, Integer age, String location, String level, String rank, String password ) throws  Exception{

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
        user.setLevel(level);
        user.setRank(rank);
        user.setRole(Role.ROLE_HERO);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        return null;
    }



}
