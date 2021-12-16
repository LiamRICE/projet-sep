package com.fastandflavorous.projetsep.facade.menus;

import java.util.*;

import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.menus.*;

/**
 * 
 */
public class AbstractMenuFacade {

    private AbstractFactory factory;
    /**
     * Default constructor
     */
    protected AbstractMenuFacade() {
        this.factory = AbstractFactory.getFactory();
    }

    public static AbstractMenuFacade getFacade(){
        return new MenuFacade();
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        return factory.getMenuManager().getMenus();
    }

    /**
     * @return
     */
    public List<Product> getProducts() {
        return factory.getMenuManager().getProducts();
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
        Menu menu = new Menu(name, image, description, price);
        factory.getMenuManager().addMenu(menu);
        factory.getMenuDAO().addMenu(menu);
    }

    /**
     * @param name
     * @param cost
     * @return
     */
    public void addProduct(String name, float cost) {
        Product product = new Product(name, cost);
        factory.getMenuManager().addProduct(product);
        factory.getMenuDAO().addProduct(product);
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
        factory.getMenuManager().removeMenu(menu);
        factory.getMenuDAO().deleteMenu(menu);
    }

    /**
     * @param product
     * @return
     */
    public void deleteProduct(Product product) {
        factory.getMenuManager().removeProduct(product);
        factory.getMenuDAO().deleteProduct(product);
    }

    /**
     * @param allergen
     * @return
     */
    public void deleteAllergen(Allergen allergen) {
        // TODO implement here
    }

}