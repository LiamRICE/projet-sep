package com.fastandflavorous.projetsep.facade.orders;

import com.fastandflavorous.projetsep.facade.menus.AbstractMenuFacade;
import com.fastandflavorous.projetsep.facade.menus.MenuFacade;
import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.menus.Allergen;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.menus.MenuManager;
import com.fastandflavorous.projetsep.model.menus.Product;
import org.junit.jupiter.api.Order;

import java.util.List;

public class AbstractOrderFacade {

    private AbstractFactory factory;
    /**
     * Default constructor
     */

    protected AbstractOrderFacade() {
        this.factory = AbstractFactory.getFactory();
    }

    public static AbstractOrderFacade getFacade(){
        return new OrderFacade();
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        return factory.getMenuDAO().getMenus();
    }

    /**
     * @param menu
     * @return
     */
    public void addMenuToOrder(Menu menu) {
        MenuManager.getMenuManager().addMenu(menu);
        factory.getMenuDAO().addMenu(menu);
    }

    /**
     * @param menu
     * @return
     */
    public void removeToOrder(Menu menu) {
        MenuManager.getMenuManager().addMenu(menu);
        factory.getMenuDAO().addMenu(menu);
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
