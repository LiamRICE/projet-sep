package com.fastandflavorous.projetsep.dao.menus;

import java.sql.Connection;
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

    public static AbstractMenuDAO getMenuDAO(Connection connection) {
        if(menuDAO == null){
            synchronized (sync){
                if(menuDAO == null){
                    menuDAO = new MySQLMenuDAO(connection);
                }
            }
        }
        return menuDAO;
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        return null;
    }

    /**
     * @param menu
     * @return
     */
    public void addMenu(Menu menu) {
        System.out.println("Adding a new menu : "+menu.toString());
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
    }

    /**
     * @return
     */
    public List<Product> getProducts() {
        return null;
    }

    /**
     * @param product
     * @return
     */
    public void addProduct(Product product) {
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
    }

    /**
     * @return
     */
    public List<Allergen> getAllergens() {
        return null;
    }

    /**
     * @param allergen
     * @return
     */
    public void addAllergen(Allergen allergen) {
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
    }

}