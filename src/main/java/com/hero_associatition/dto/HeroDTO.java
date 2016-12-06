package com.hero_associatition.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by markoreljic on 2.12.16..
 */
public class HeroDTO {

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

    @NotNull
    @Size(min=3, max= 400)
    private String location;

    @NotNull
    @Size(min = 1, max = 1)
    private String level;

    @NotNull
    @Size(min = 1, max = 4)
    private String rank;

    public void setId( Long id ) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setAlias( String alias ) {
        this.alias = alias;
    }

    public void setRace( String race ) {
        this.race = race;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public void setLocation( String location ) {
        this.location = location;
    }

    public void setLevel( String level ) {
        this.level = level;
    }

    public void setRank( String rank ) {
        this.rank = rank;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getLevel() {
        return level;
    }

    public String getRank() {
        return rank;
    }

    public String getPassword() {
        return password;
    }


}
