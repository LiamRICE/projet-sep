package com.fastandflavorous.projetsep.model.menus;


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
        this.products = new ArrayList<>();
        this.allergens = new ArrayList<>();
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
    private List<Product> products;
    private List<Allergen> allergens;

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
        this.products.add(product);
    }

    /**
     * @param product
     * @return
     */
    public void removeProduct(Product product) {
        for(Menu m : menus){
            if(m.getProducts().contains(product)){
                m.removeProduct(product);
            }
        }
        this.products.remove(product);
    }

    /**
     * @param allergen
     * @return
     */
    public void addAllergen(Allergen allergen) {
        this.allergens.add(allergen);
    }

    /**
     * @param allergen
     * @return
     */
    public void removeAllergen(Allergen allergen) {
        for(Product p : products){
            if(p.getAllergens().contains(allergen)){
                p.removeAllergen(allergen);
            }
        }
        this.allergens.remove(allergen);
    }

    public void setMenuList(List<Menu> menus){
        this.menus = menus;
    }

    public void setProductList(List<Product> products){
        this.products = products;
    }

    public void setAllergenList(List<Allergen> allergens){
        this.allergens = allergens;
    }

    public List<Menu> getMenus(){
        return this.menus;
    }

    public List<Product> getProducts(){
        return this.products;
    }

    public List<Allergen> getAllergens(){
        return this.allergens;
    }

}