package com.fastandflavorous.projetsep.dao.menus;

import com.fastandflavorous.projetsep.model.menus.Allergen;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.menus.Product;
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

    @Override
    public List<Product> getProducts(){
        String query = "SELECT * FROM Product;";
        Product prod = null;
        List<Product> productList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                prod = new Product(rs.getString("name"), rs.getFloat("cost"));
                productList.add(prod);
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        return productList;
    }

    @Override
    public List<Allergen> getAllergens(){
        String query = "SELECT * FROM Allergen;";
        Allergen all = null;
        List<Allergen> allergenList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                all = new Allergen(rs.getString("name"));
                allergenList.add(all);
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        return allergenList;
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

    private int freeProductIndex(){
        int index = 0;
        String query = "SELECT idProduct FROM Product;";
        List<Integer> intList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                intList.add(rs.getInt("idProduct"));
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

    private int freeAllergenIndex(){
        int index = 0;
        String query = "SELECT idAllergen FROM Allergen;";
        List<Integer> intList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                intList.add(rs.getInt("idAllergen"));
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
        // link menu and it's products
    }

    @Override
    public void addProduct(Product product){
        int id = freeProductIndex();
        String query = "INSERT INTO Product VALUES (" + id + ",'" + product.getName() + "'," + product.getCost() + ");";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        // link product and it's allergens
    }

    @Override
    public void addAllergen(Allergen allergen){
        int id = freeAllergenIndex();
        String query = "INSERT INTO Allergen VALUES (" + id + ",'" + allergen.getName() + "');";
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
        // remove all links to this menu from products
    }

    public void deleteProduct(Product product) {
        String query = "DELETE FROM Product WHERE name='" + product.getName() + "';";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        // remove all links to this product from menu and allergen
    }

    public void deleteAllergen(Allergen allergen) {
        String query = "DELETE FROM Allergen WHERE name='" + allergen.getName() + "';";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        // remove all links to this allergen from products
    }

}
