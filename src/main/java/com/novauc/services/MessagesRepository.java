package com.novauc.services;

import com.novauc.entities.Messages;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by souporman on 3/28/17.
 */
public interface MessagesRepository extends CrudRepository<Messages,Integer> {
//    void deleteFirstById(int id);
}
