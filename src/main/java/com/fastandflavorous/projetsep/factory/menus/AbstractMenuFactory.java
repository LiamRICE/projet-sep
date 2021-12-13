package com.fastandflavorous.projetsep.factory.menus;

import java.util.*;

import com.fastandflavorous.projetsep.dao.menus.MenuDAO;
import com.fastandflavorous.projetsep.factory.users.UserFactory;
import com.fastandflavorous.projetsep.model.menus.*;

/**
 * 
 */
public class AbstractMenuFactory {

    /**
     * Default constructor
     */
    protected AbstractMenuFactory() {
        this.menuDAO = MenuDAO.getMenuDAO();
        this.menuManager = MenuManager.getMenuManager();
    }

    /**
     * 
     */
    private static AbstractMenuFactory factory;
    private MenuManager menuManager;
    private MenuDAO menuDAO;
    private static Object sync = new Object();

    public static AbstractMenuFactory getFactory() {
        if(factory == null){
            synchronized (sync){
                if(factory == null){
                    factory = new MenuFactory();
                }
            }
        }
        return factory;
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        // get list of menus from DAO and write them to the menuManager
        return menuManager.getMenus();
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
        Menu menu = new Menu(name, image, description, price);
        menuDAO.addMenu(menu);
        menuManager.addMenu(menu);
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