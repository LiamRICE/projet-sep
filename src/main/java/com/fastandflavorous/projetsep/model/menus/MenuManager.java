package com.fastandflavorous.projetsep.model.menus;

import com.fastandflavorous.projetsep.factory.menus.MenuFactory;

import java.util.*;

/**
 * 
 */
public class MenuManager {

    /**
     * Default constructor
     */
    private MenuManager() {
        this.menus = new ArrayList<>();
    }

    /**
     * 
     */
    private static MenuManager menuManager;
    private static Object sync = new Object();

    /**
     * 
     */
    private List<Menu> menus;

    public static MenuManager getMenuManager() {
        if(menuManager == null){
            synchronized (sync){
                if(menuManager == null){
                    menuManager = new MenuManager();
                }
            }
        }
        return menuManager;
    }


    /**
     * @param menu
     * @return
     */
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    /**
     * @param menu
     * @return
     */
    public void removeMenu(Menu menu) {
        menus.remove(menu);
    }

    /**
     * @param menu
     * @return
     */
    public void modifyMenu(Menu menu) {
        // TODO implement here
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
    public void removeProduct(Product product) {
        // TODO implement here
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
    public void removeAllergen(Allergen allergen) {
        // TODO implement here
    }

    public List<Menu> getMenus(){
        return this.menus;
    }

}