package com.fastandflavorous.projetsep.model.users;

import java.util.*;

/**
 * 
 */
public abstract class User {

    /**
     * Default constructor
     */
    protected User(String name) {
        this.name = name;
    }

    /**
     * 
     */
    private String name;

    /**
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

}