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
    }

    /**
     * @param menu
     * @return
     */
    public void deleteMenu(Menu menu) {
        System.out.println("Deleting menu : "+menu.toString());
    }
}