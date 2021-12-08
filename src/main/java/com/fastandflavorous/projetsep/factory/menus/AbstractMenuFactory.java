package com.fastandflavorous.projetsep.factory.menus;

import java.util.*;
import com.fastandflavorous.projetsep.model.menus.*;

/**
 * 
 */
public class AbstractMenuFactory {

    /**
     * Default constructor
     */
    public AbstractMenuFactory() {
    }

    /**
     * 
     */
    private static AbstractMenuFactory menuFactory;

    /**
     * @return
     */
    public List<Menu> getMenus() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Product> getProducts() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Allergen> getAllergens() {
        // TODO implement here
        return null;
    }

    /**
     * @param name
     * @param description
     * @param price
     * @return
     */
    public void addMenu(String name, String description, float price) {
        // TODO implement here
    }

    /**
     * @param name
     * @param cost
     * @return
     */
    public void addProduct(String name, float cost) {
        // TODO implement here
    }

    /**
     * @param name
     * @return
     */
    public void addAllergen(String name) {
        // TODO implement here
    }

    /**
     * @param name
     * @return
     */
    public void setMenuName(String name) {
        // TODO implement here
    }

    /**
     * @param description
     * @return
     */
    public void setMenuDescription(String description) {
        // TODO implement here
    }

    /**
     * @param price
     * @return
     */
    public void setMenuPrice(float price) {
        // TODO implement here
    }

    /**
     * @param name
     * @return
     */
    public void setProductName(String name) {
        // TODO implement here
    }

    /**
     * @param cost
     * @return
     */
    public void setProductCost(float cost) {
        // TODO implement here
    }

    /**
     * @param name
     * @return
     */
    public void setAllergenName(float name) {
        // TODO implement here
    }

    /**
     * @param menu
     * @param product
     * @return
     */
    public void addProductToMenu(Menu menu, Product product) {
        // TODO implement here
    }

    /**
     * @param product
     * @param allergen
     * @return
     */
    public void addAllergenToProduct(Product product, Allergen allergen) {
        // TODO implement here
    }

    /**
     * @param menu
     * @return
     */
    public void deleteMenu(Menu menu) {
        // TODO implement here
    }

    /**
     * @param product
     * @return
     */
    public void deleteProduct(Product product) {
        // TODO implement here
    }

    /**
     * @param allergen
     * @return
     */
    public void deleteAllergen(Allergen allergen) {
        // TODO implement here
    }

}