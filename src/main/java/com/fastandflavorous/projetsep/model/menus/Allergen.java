package com.fastandflavorous.projetsep.model.menus;

import java.util.*;

/**
 * 
 */
public class Allergen {

    /**
     * Default constructor
     */
    public Allergen(String name) {
        this.name = name;
    }

    /**
     * 
     */
    private String name;

    public String toString(){
        return this.name;
    }

    public String getName() {
        return this.name;
    }
}