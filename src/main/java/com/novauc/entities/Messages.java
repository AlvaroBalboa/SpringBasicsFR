package com.novauc.entities;

import javax.persistence.*;

/**
 * Created by souporman on 3/13/17.
 */

@Entity
@Table(name = "messages")
public class Messages{

    @Id
    @GeneratedValue
    int id;


    @Column(nullable = false)
    String message;

    @ManyToOne
    User user;



    public Messages() {
    }

    public Messages(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
