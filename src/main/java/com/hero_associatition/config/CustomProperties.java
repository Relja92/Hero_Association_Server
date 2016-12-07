package com.hero_associatition.config;

/**
 * Created by markoreljic on 7.12.16..
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;


@Service
@ConfigurationProperties(prefix = "custom", ignoreUnknownFields = false)
public class CustomProperties {

    private String secretKey= "markoreljic992";

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }







}