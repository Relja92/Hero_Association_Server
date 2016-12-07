package com.hero_associatition.services.Auth;

import com.hero_associatition.config.CustomProperties;
import com.hero_associatition.dto.LoginResponse;
import com.hero_associatition.models.Hero;
import com.hero_associatition.repositories.HeroRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by markoreljic on 6.12.16..
 */
@Service
public class AuthenticationService {

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private HeroRepository heroRepository;

    @Inject
    private CustomProperties customProperties;

    public LoginResponse login( String email, String password) throws Exception {
        final Hero hero = this.heroRepository.findByEmail(email);

        if(hero == null){
            throw new Exception();
        }

        if (!passwordEncoder.matches(password, hero.getPassword()))
            throw new Exception("Username or password is wrong");

        final LoginResponse response = new LoginResponse();
        response.setName(hero.getName());
        response.setAlias(hero.getAlias());
        response.setLocation(hero.getLocation());
        response.setAge(hero.getAge());
        response.setId(hero.getId());
        response.setRank(hero.getRank());
        response.setRole(hero.getRole());
        response.setLevel(hero.getLevel());


        return response;

    }


}
