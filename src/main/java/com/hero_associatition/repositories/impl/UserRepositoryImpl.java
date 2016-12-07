package com.hero_associatition.repositories.impl;

import com.hero_associatition.models.User;
import com.hero_associatition.models.QUser;


import com.hero_associatition.repositories.UserRepositoryCustom;
import com.querydsl.jpa.JPQLQueryFactory;
import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by markoreljic on 6.12.16..
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public Optional<User> findByEmailPresent( String email) {
        final QUser user = QUser.user;
        return Optional.ofNullable(factory.select(user).from(user).where(user.email.eq(email)).fetchOne());
    }

    @Override
    public User findByEmail( String email) {
        final QUser user = QUser.user;
        return factory.select(user).from(user).where(user.email.eq(email)).fetchOne();
    }
}
