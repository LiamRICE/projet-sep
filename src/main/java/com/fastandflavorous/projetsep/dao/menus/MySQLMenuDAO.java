package com.fastandflavorous.projetsep.dao.menus;

import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.users.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class MySQLMenuDAO extends AbstractMenuDAO {


    private Connection connection ;

    /**
     * Default constructor
     */
    public MySQLMenuDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Menu> getMenus() {
        String query = "SELECT * FROM Menu;";
        Menu menu = null;
        List<Menu> menuList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                menu = new Menu(rs.getString("name"), rs.getString("image"), rs.getString("description"),rs.getFloat("price"));
                menuList.add(menu);
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        return menuList;
    }

    private int freeMenuIndex(){
        int index = 0;
        String query = "SELECT idMenu FROM Menu;";
        List<Integer> intList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                intList.add(rs.getInt("idMenu"));
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        if(!intList.isEmpty()){
            for(Integer i : intList){
                if(i>=index){
                    index = i;
                }
            }
            index += 1;
        }
        return index;
    }

    @Override
    public void addMenu(Menu menu){
        int id = freeMenuIndex();
        String query = "INSERT INTO Menu VALUES (" + id + ",'" + menu.getName() + "','" + menu.getImage() + "','" + menu.getDescription() + "'," + menu.getPrice() + ");";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void deleteMenu(Menu menu) {
        String query = "DELETE FROM Menu WHERE name='" + menu.getName() + "';";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void editMenu(Menu menu){
        String query = "UPDATE Menu SET image='"+menu.getImage()+"', description='"+menu.getDescription()+"', price="+menu.getPrice()+" WHERE name='"+menu.getName()+"';";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
