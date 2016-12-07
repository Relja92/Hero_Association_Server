package com.hero_associatition;

import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HeroAssociationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroAssociationApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	@Bean
	public JPQLQueryFactory factory( EntityManager entityManager) {
		return new JPAQueryFactory(entityManager);
	}
}
