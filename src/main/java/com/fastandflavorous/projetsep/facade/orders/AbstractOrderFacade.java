package com.fastandflavorous.projetsep.facade.orders;


import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.menus.MenuManager;


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
     * @param menu
     * @return
     */
    public void deleteMenu(Menu menu) {
        MenuManager.getMenuManager().removeMenu(menu);
        factory.getMenuDAO().deleteMenu(menu);
    }
}
