package com.fastandflavorous.projetsep.dao.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Floor;
import com.fastandflavorous.projetsep.model.restaurant.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLFloorDAO extends AbstractFloorDAO{
    
    private Connection connection;

    public MySQLFloorDAO(Connection connection) {
        this.connection = connection;
    }

    public void setFloorName(int idFloor, String newName) {
        String update = "UPDATE Floor SET name = '"+newName+"' WHERE idFloor="+ idFloor+";";
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }

    }

    public List<Floor> getAllFloors(){
        String query = "SELECT * FROM Floor;";
        List<Floor> Floors = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Floors.add(new Floor(rs.getInt("idFloor"),rs.getString("name")));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return Floors;
    }

    public Floor getFloorById(int idFloor){
        String query = "SELECT * FROM Floor WHERE idFloor='"+idFloor+"';";
        Floor Floor = null;
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Floor = new Floor(rs.getInt("idFloor"),rs.getString("name"));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return Floor;
    }

    public Floor addFloor(String name){
        Statement stmt = null;
        ResultSet rs = null;
        int autoIncKeyFromApi = -1;
        java.util.Date creationDate = new java.util.Date();

        try {
            stmt = connection.createStatement();
            String update = "INSERT INTO Floor VALUES(NULL,'"+name+"');";
            stmt.executeUpdate(
                    update,
                    Statement.RETURN_GENERATED_KEYS);



            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            } else {

                // throw an exception from here
            }

        }
        catch (Exception e) {
            System.err.println(e);
        }
        return new Floor(autoIncKeyFromApi,name);
    }


    public void removeFloorById(int idFloor){
        String update = "DELETE FROM Floor WHERE idFloor  ="+idFloor+";";
        Floor Floor = null;
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }

    }
}
