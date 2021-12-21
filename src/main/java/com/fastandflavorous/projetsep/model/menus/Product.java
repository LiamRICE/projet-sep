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
        this.setCost(cost);
        this.allergens = new ArrayList<>();
    }

    private String name;

    private float cost;

    private List<Allergen> allergens;

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public void removeAllergen(Allergen allergen){
        this.getAllergens().remove(allergen);
    }

    public void addAllergen(Allergen a){
        this.getAllergens().add(a);
    }

    public String toString(){
        String ret = this.getName();
        return ret;
    }

    /**
     *
     */
    public String getName() {
        return name;
    }

    /**
     *
     */
    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}