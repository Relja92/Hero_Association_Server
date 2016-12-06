package com.hero_associatition.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by markoreljic on 1.12.16..
 */
@Entity
public class Hero {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String email;
    private String name;
    private String alias;
    private String race;
    private int age;
    private String location;
    private String level;
    private String rank;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public Hero() {
    //JPA only
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() { return email;}

    public void setEmail( String email ) {this.email = email;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }






}
