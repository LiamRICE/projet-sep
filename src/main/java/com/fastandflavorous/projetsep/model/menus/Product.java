package com.fastandflavorous.projetsep.model.menus;

import java.util.*;

/**
 * 
 */
public class Product {

    /**
     * Default constructor
     */
    public Product(String name, float cost) {
        this.name = name;
        this.cost = cost;
        this.allergens = new ArrayList<>();
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private float cost;

    private List<Allergen> allergens;

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public void removeAllergen(Allergen allergen){
        this.allergens.remove(allergen);
    }

    public void addAllergen(Allergen a){
        this.allergens.add(a);
    }

    public String toString(){
        String ret = this.name;
        return ret;
    }
}