package com.novauc.services;

import com.novauc.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by souporman on 3/28/17.
 */
public interface UserRepository extends CrudRepository<User,Integer>{
    User findFirstByName(String name);
}
