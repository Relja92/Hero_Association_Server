package com.hero_associatition.repositories;

import com.hero_associatition.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by markoreljic on 1.12.16..
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
