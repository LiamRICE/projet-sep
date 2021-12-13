package com.fastandflavorous.projetsep.facade.menus;

import java.util.*;

import com.fastandflavorous.projetsep.factory.menus.AbstractMenuFactory;
import com.fastandflavorous.projetsep.factory.users.AbstractUserFactory;
import com.fastandflavorous.projetsep.model.menus.*;

/**
 * 
 */
public class AbstractMenuFacade {

    private AbstractMenuFactory factory;
    /**
     * Default constructor
     */
    protected AbstractMenuFacade() {
        this.factory = AbstractMenuFactory.getFactory();
    }

    public static AbstractMenuFacade getFacade(){
        return new MenuFacade();
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        return factory.getMenus();
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
    public void addMenu(String name, String image, String description, float price) {
        factory.addMenu(name, image, description, price);
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