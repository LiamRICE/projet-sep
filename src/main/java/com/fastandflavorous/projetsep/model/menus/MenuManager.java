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

    public void setMenuList(List<Menu> menus){
        this.menus = menus;
    }

    public List<Menu> getMenus(){
        return this.menus;
    }

}