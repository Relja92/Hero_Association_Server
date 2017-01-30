package com.hero_associatition.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by markoreljic on 2.12.16..
 */
public class UserDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String alias;

    @NotNull
    private String race;

    @NotNull
    @NumberFormat
    private int age;

    private int gold;
    private int level;
    private int experience;

    @NotNull
    @Size(min=3, max= 400)
    private String location;


    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias( String alias ) {
        this.alias = alias;
    }

    public String getRace() {
        return race;
    }

    public void setRace( String race ) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation( String location ) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
    public int getGold() {
        return gold;
    }

    public void setGold( int gold ) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel( int level ) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience( int experience ) {
        this.experience = experience;
    }
}
