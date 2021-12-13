package com.fastandflavorous.projetsep.model.menus;

import java.util.*;

/**
 * 
 */
public class Menu {

    /**
     * Default constructor
     */
    public Menu(String name, String image, String description, float price){
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.products = new ArrayList<>();
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String image;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private float price;

    private List<Product> products;



    /**
     * @return
     */
    public List<Allergen> getAllergens() {
        // TODO implement here
        return null;
    }

    /**
     * @param markup
     * @return
     */
    private float getDefaultPrice(float markup) {
        // TODO implement here
        return 0.0f;
    }

    public String toString(){
        String ret = this.name+" | ";
        for(Product product : products){
            ret += product.toString() + ", ";
        }
        ret += " | "+this.price;
        return ret;
    }

}