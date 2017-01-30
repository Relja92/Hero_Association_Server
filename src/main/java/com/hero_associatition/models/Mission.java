package com.hero_associatition.models;

import com.hero_associatition.models.enumerations.Level;
import com.hero_associatition.models.enumerations.Role;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by markoreljic on 8.12.16..
 */
@Entity
public class Mission {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NumberFormat
    private int experience;

    @NumberFormat
    private int gold;

    //minimum level to play this mission
    @NumberFormat
    private int minLevel;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;

    public Mission(){
        //JPA Only
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
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

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel( int minLevel ) {
        this.minLevel = minLevel;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel( Level level ) {
        this.level = level;
    }
}
