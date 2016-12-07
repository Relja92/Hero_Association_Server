package com.hero_associatition.repositories;

import com.hero_associatition.models.User;

import java.util.Optional;

/**
 * Created by markoreljic on 6.12.16..
 */
public interface UserRepositoryCustom {
    Optional<User> findByEmailPresent( String email);
    User findByEmail(String email);
}
