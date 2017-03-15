package com.example.koenengels.mylist.model;

/**
 * Created by Koen Engels on 15/03/2017.
 */

public class Contact {
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
}
