package com.hero_associatition.repositories;

import com.hero_associatition.models.Hero;

/**
 * Created by markoreljic on 6.12.16..
 */
public interface HeroRepositoryCustom {
    Hero findByEmail( String email);

}
