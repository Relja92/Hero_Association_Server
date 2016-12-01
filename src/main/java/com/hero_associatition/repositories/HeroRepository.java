package com.hero_associatition.repositories;

import com.hero_associatition.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by markoreljic on 1.12.16..
 */
public interface HeroRepository extends JpaRepository<Hero, Long> {

}
