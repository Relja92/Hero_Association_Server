package com.hero_associatition.repositories.impl;

import com.hero_associatition.models.Hero;
import com.hero_associatition.models.QHero;
import com.hero_associatition.repositories.HeroRepositoryCustom;


import com.querydsl.jpa.JPQLQueryFactory;
import javax.inject.Inject;

/**
 * Created by markoreljic on 6.12.16..
 */
public class HeroRepositoryImpl implements HeroRepositoryCustom {

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public Hero findByEmail( String email) {
        final QHero hero = QHero.hero;
        return factory.select(hero).from(hero).where(hero.email.eq(email)).fetchOne();
    }
}
