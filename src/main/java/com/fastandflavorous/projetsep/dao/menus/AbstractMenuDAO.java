package com.fastandflavorous.projetsep.dao.menus;

import java.util.*;

import com.fastandflavorous.projetsep.model.menus.*;

/**
 * 
 */
public abstract class AbstractMenuDAO {

    /**
     * Default constructor
     */
    public AbstractMenuDAO() {
    }

    /**
     * 
     */
    private static AbstractMenuDAO menuDAO;
    private static Object sync = new Object();

    public static AbstractMenuDAO getMenuDAO() {
        if(menuDAO == null){
            synchronized (sync){
                if(menuDAO == null){
                    menuDAO = new MySQLMenuDAO();
                }
            }
        }
        return menuDAO;
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        // TODO implement here
        return null;
    }

    /**
     * @param menu
     * @return
     */
    public void addMenu(Menu menu) {
        System.out.println("Adding a new menu : "+menu.toString());
        // TODO implement here
    }

    /**
     * @param menu
     * @return
     */
    public void editMenu(Menu menu) {
        // TODO implement here
    }

    /**
     * @param menu
     * @return
     */
    public void deleteMenu(Menu menu) {
        System.out.println("Deleting menu : "+menu.toString());
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Product> getProducts() {
        // TODO implement here
        return null;
    }

    /**
     * @param product
     * @return
     */
    public void addProduct(Product product) {
        // TODO implement here
    }

    /**
     * @param product
     * @return
     */
    public void editProduct(Product product) {
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
     * @return
     */
    public List<Allergen> getAllergens() {
        // TODO implement here
        return null;
    }

    /**
     * @param allergen
     * @return
     */
    public void addAllergen(Allergen allergen) {
        // TODO implement here
    }

    /**
     * @param allergen
     * @return
     */
    public void editAllergen(Allergen allergen) {
        // TODO implement here
        // remove all links to this product from menus
    }

    /**
     * @param allergen
     * @return
     */
    public void deleteAllergen(Allergen allergen) {
        // TODO implement here
        // remove all links to this allergen from products
    }

}