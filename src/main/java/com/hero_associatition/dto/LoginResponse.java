package com.hero_associatition.dto;

import com.hero_associatition.models.enumerations.Role;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

/**
 * Created by markoreljic on 6.12.16..
 */
public class LoginResponse {
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

    public String getAlias() {
        return alias;
    }

    public void setAlias( String alias ) {
        this.alias = alias;
    }

    public Number getAge() {
        return age;
    }

    public void setAge( Number age ) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel( String level ) {
        this.level = level;
    }

    public String getRank() {
        return rank;
    }

    public void setRank( String rank ) {
        this.rank = rank;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation( String location ) {
        Location = location;
    }

    @NotNull
    private Long id;

    @Size(min = 1, max = 50)
    private String name;

    @Size(min = 1, max = 50)
    private String alias;

    private Number age;

    private String level;

    private String rank;

    private String Location;

    private String AccessToken;


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole( Role role ) {
        this.role = role;
    }

    public String getAccessToken() {
        return AccessToken;
    }


    public void setAccessToken( String accessToken ) {
        AccessToken = accessToken;
    }


}
