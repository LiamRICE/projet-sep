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
        this.setImage(image);
        this.setDescription(description);
        this.setPrice(price);
    }

    private String name;

    private String image;

    private String description;

    private float price;

    /**
     * @param markup
     * @return
     */
    private float getDefaultPrice(float markup) {
        return 0.0f;
    }

    public String toString(){
        String ret = this.getName() + " | " + this.getPrice();
        return ret;
    }

    /**
     *
     */
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     */
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     */
    public String getName() {
        return name;
    }
}