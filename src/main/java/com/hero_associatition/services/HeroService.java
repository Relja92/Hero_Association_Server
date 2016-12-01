package com.hero_associatition.services;

import com.hero_associatition.models.Hero;
import com.hero_associatition.repositories.HeroRepository;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

/**
 * Created by markoreljic on 1.12.16..
 */
@Service
public class HeroService {
    @Inject
    HeroRepository heroRepository;

    public void createHero(String name, String alias, String race, Integer age, String location, String level, String rank,String password ) throws  Exception{
        final Hero hero = new Hero();

        hero.setName(name);
        hero.setAlias(alias);
        hero.setRace(race);
        hero.setAge(age);
        hero.setLocation(location);
        hero.setLevel(level);
        hero.setRank(rank);
        hero.setPassword(password);
        heroRepository.save(hero);
        
    }

    public void editHero(Long id, String name, String alias, String race, Integer age, String location, String level, String rank,String password ) throws Exception {
        final Hero hero = heroRepository.findOne(id);

        if(hero == null){
            throw new Exception();
        }
        hero.setName(name);
        hero.setAlias(alias);
        hero.setRace(race);
        hero.setAge(age);
        hero.setLocation(location);
        hero.setLevel(level);
        hero.setRank(rank);
        hero.setPassword(password);
        heroRepository.save(hero);
    }

    public void deleteHero(Long id) throws Exception{
        final Hero hero = heroRepository.findOne(id);

        if(hero == null){
            throw new Exception();
        }

        heroRepository.delete(id);
    }

}
