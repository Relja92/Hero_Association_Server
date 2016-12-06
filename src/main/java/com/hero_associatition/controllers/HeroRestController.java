package com.hero_associatition.controllers;

import com.hero_associatition.dto.HeroDTO;
import com.hero_associatition.models.Hero;
import com.hero_associatition.repositories.HeroRepository;
import com.hero_associatition.services.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by markoreljic on 1.12.16..
 */
@RestController
@RequestMapping("/heroes")
public class HeroRestController {
    @Inject
    private HeroService heroService;

    private final HeroRepository heroRepository;

    public HeroRestController( HeroRepository heroRepository ) {
        this.heroRepository = heroRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    Collection<Hero> getAll(){
        return this.heroRepository.findAll();
    }

    @RequestMapping(value = "/{heroId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Hero> getHero( @PathVariable Long heroId){
        try{
            return ResponseEntity.ok(this.heroRepository.findOne(heroId));
        }catch (Exception e){
            throw new Error();
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> addHero( @RequestBody @Valid HeroDTO hero){
        try {
            heroService.createHero(hero.getEmail(),hero.getName(), hero.getAlias(), hero.getRace(), hero.getAge(), hero.getLocation(), hero.getLevel(), hero.getRank(), hero.getPassword());
        }catch (Exception e){
            throw new Error();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{heroId}", method = RequestMethod.PUT, consumes = "application/json")
    public Hero updateHero(@RequestBody @Valid Hero hero, @PathVariable Long heroId){
        hero.setId(heroId);
        try {
            heroService.editHero(heroId, hero.getEmail(), hero.getName(), hero.getAlias(), hero.getRace(), hero.getAge(), hero.getLocation(), hero.getLevel(), hero.getRank());
        }catch (Exception e){
            throw new Error();
        }
        return hero;
    }
    @RequestMapping(value = "/delete/{heroId}", method = RequestMethod.DELETE, consumes = "application/json")
    public ResponseEntity<Void> deleteHero( @PathVariable Long heroId) {
        try{
            heroService.deleteHero(heroId);
        }catch (Exception e){
            throw new Error();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
