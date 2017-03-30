package com.novauc.entities;

import javax.persistence.*;

/**
 * Created by souporman on 3/13/17.
 */


@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;


    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public User() {
    }
    public User(String name) {

        this.name = name;
    }

}
