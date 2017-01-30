package com.hero_associatition.models;

import com.hero_associatition.models.enumerations.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by markoreljic on 1.12.16..
 */
@Entity
public class User {
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
    private int level;
    private int attack;
    private int defense;
    private int luck;
    private int agility;
    private int experience;
    private int gold;
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
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

    public int getGold() {
        return gold;
    }

    public void setGold( int gold ) {
        this.gold = gold;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole( Role role ) {
        this.role = role;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack( int attack ) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense( int defense ) {
        this.defense = defense;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck( int luck ) {
        this.luck = luck;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility( int agility ) {
        this.agility = agility;
    }
}
