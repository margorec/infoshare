package org.infoshare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Random;

/**
 * Created by marcin on 11.05.2017.
 */
public class User {

    private String name;
    private String surname;
    private int id;
    private Credentials credentials;

    public User(String name, String surname, Credentials credentials) {
        this.name = name;
        this.surname = surname;
        this.id = generateId();
        this.credentials = credentials;
    }

    public User() {
    }

    private int generateId() {
        Random r = new Random();
        return r.nextInt(Integer.MAX_VALUE);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    @JsonIgnore
    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

}
