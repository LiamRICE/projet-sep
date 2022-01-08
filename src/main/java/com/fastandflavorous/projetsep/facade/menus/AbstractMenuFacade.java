package com.fastandflavorous.projetsep.facade.menus;

import java.util.*;

import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.menus.*;

/**
 * 
 */
public abstract class AbstractMenuFacade {

    protected AbstractFactory factory;
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
    public abstract List<Menu> getMenus();

    /**
     * @param name
     * @param description
     * @param price
     * @return
     */
    public abstract Menu addMenu(String name, String image, String description, float price);

    /**
     * @param newMenu
     * @return
     */
    public abstract void setMenu(Menu newMenu);

    /**
     * @param menu
     * @return
     */
    public abstract void deleteMenu(Menu menu);
}