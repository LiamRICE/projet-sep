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
        List<Menu> menus = factory.getMenuDAO().getMenus();
        MenuManager.getMenuManager().setMenuList(menus);
        return menus;
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
     * @param newMenu
     * @return
     */
    public void setMenu(Menu newMenu) {
        factory.getMenuDAO().editMenu(newMenu);
    }

    /**
     * @param menu
     * @return
     */
    public void deleteMenu(Menu menu) {
        MenuManager.getMenuManager().removeMenu(menu);
        factory.getMenuDAO().deleteMenu(menu);
    }
}