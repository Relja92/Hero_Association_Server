package com.hero_associatition.services;

import com.hero_associatition.models.User;
import com.hero_associatition.models.enumerations.Role;
import com.hero_associatition.repositories.UserRepository;
import com.hero_associatition.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

/**
 * Created by markoreljic on 1.12.16..
 */
@Service
public class UserService {
    @Inject
    UserRepository userRepository;

    @Inject
    PasswordEncoder passwordEncoder;
//    public void createUser(String email, String name, String alias, String race, Integer age, String location, String level, String rank,String password ) throws  Exception{
//        final User user = new User();
//        user.setEmail(email);
//        user.setName(name);
//        user.setAlias(alias);
//        user.setRace(race);
//        user.setAge(age);
//        user.setLocation(location);
//        user.setLevel(level);
//        user.setRank(rank);
//        user.setRole(Role.ROLE_HERO);
//        user.setPassword(passwordEncoder.encode(password));
//        userRepository.save(user);
//
//    }

    public void editUser(Long id, String email,  String name, String alias, String race, Integer age, String location) throws Exception {
        final User user = userRepository.findOne(id);

        if(user == null){
            throw new Exception();
        }

        user.setEmail(email);
        user.setName(name);
        user.setAlias(alias);
        user.setRace(race);
        user.setAge(age);
        user.setLocation(location);
        userRepository.save(user);
    }

    public void deleteUser(Long id) throws Exception{
        final User user = userRepository.findOne(id);

        if(user == null){
            throw new Exception();
        }

        userRepository.delete(id);
    }

}
