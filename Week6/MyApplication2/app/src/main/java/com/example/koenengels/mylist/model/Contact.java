package com.example.koenengels.mylist.model;

import java.io.Serializable;

/**
 * Created by Koen Engels on 15/03/2017.
 */

public class Contact implements Serializable{
    private final String name;
    private final String username;
    private final String email;

    public Contact(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", name, username, email);
    }
}
