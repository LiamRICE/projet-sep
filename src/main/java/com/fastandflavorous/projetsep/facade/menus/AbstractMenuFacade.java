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
        return factory.getMenuDAO().getMenus();
    }

    /**
     * @return
     */
    public List<Product> getProducts() {
        return factory.getMenuDAO().getProducts();
    }

    /**
     * @return
     */
    public List<Allergen> getAllergens() {
        return factory.getMenuDAO().getAllergens();
    }

    /**
     * @param name
     * @param description
     * @param price
     * @return
     */
    public Menu addMenu(String name, String image, String description, float price) {
        Menu menu = new Menu(name, image, description, price);
        MenuManager.getMenuManager().addMenu(menu);
        factory.getMenuDAO().addMenu(menu);
        return menu;
    }

    /**
     * @param name
     * @param cost
     * @return
     */
    public Product addProduct(String name, float cost) {
        Product product = new Product(name, cost);
        MenuManager.getMenuManager().addProduct(product);
        factory.getMenuDAO().addProduct(product);
        return product;
    }

    /**
     * @param name
     * @return
     */
    public void addAllergen(String name) {
        Allergen allergen = new Allergen(name);
        MenuManager.getMenuManager().addAllergen(allergen);
        factory.getMenuDAO().addAllergen(allergen);
    }

    /**
     * @param newMenu
     * @return
     */
    public void setMenu(Menu newMenu) {
        if(MenuManager.getMenuManager().getMenus().contains(newMenu)){
            System.out.println("Menu has been modified in memory");
        }
        // TODO update in DAO
    }

    /**
     * @param newProduct
     * @return
     */
    public void setProduct(Product newProduct) {
        // TODO implement here
    }

    /**
     * @param menu
     * @param product
     * @return
     */
    public void addProductToMenu(Menu menu, Product product) {
        menu.addProduct(product);
    }

    /**
     * @param product
     * @param allergen
     * @return
     */
    public void addAllergenToProduct(Product product, Allergen allergen) {
        product.addAllergen(allergen);
    }

    /**
     * @param menu
     * @return
     */
    public void deleteMenu(Menu menu) {
        MenuManager.getMenuManager().removeMenu(menu);
        factory.getMenuDAO().deleteMenu(menu);
    }

    /**
     * @param product
     * @return
     */
    public void deleteProduct(Product product) {
        MenuManager.getMenuManager().removeProduct(product);
        factory.getMenuDAO().deleteProduct(product);
    }

    /**
     * @param allergen
     * @return
     */
    public void deleteAllergen(Allergen allergen) {
        MenuManager.getMenuManager().removeAllergen(allergen);
        factory.getMenuDAO().deleteAllergen(allergen);
    }

}