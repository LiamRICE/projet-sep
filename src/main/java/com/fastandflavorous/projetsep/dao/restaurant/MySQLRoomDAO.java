package com.fastandflavorous.projetsep.dao.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Floor;
import com.fastandflavorous.projetsep.model.restaurant.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRoomDAO extends AbstractRoomDAO{

    private Connection connection;

    public MySQLRoomDAO(Connection connection) {
        this.connection = connection;
    }

    public void setRoomName(int idRoom, String newName) {
        String update = "UPDATE Room SET name = '"+newName+"' WHERE idRoom="+ idRoom+";";
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }

    }

    public List<Room> getAllRooms(){
        String query = "SELECT * FROM Room;";
        List<Room> Rooms = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Rooms.add(new Room(rs.getInt("idRoom"),rs.getInt("idFloor"),rs.getString("name"),rs.getFloat("squareMeter")));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return Rooms;
    }

    public Room getRoomById(int idRoom){
        String query = "SELECT * FROM Room WHERE idRoom='"+idRoom+"';";
        Room Room = null;
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Room = new Room(rs.getInt("idRoom"),rs.getInt("idFloor"),rs.getString("name"),rs.getFloat("squareMeter"));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return Room;
    }

    public Room addRoom(int idFloor, String name, float squareMeter){
        Statement stmt = null;
        ResultSet rs = null;
        int autoIncKeyFromApi = -1;
        java.util.Date creationDate = new java.util.Date();

        try {
            stmt = connection.createStatement();
            String update = "INSERT INTO Room VALUES(NULL,"+idFloor+",'"+name+"',"+squareMeter+");";
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
        return new Room(autoIncKeyFromApi,idFloor,name,squareMeter);
    }


    public void removeRoomById(int idRoom){
        String update = "DELETE FROM Room WHERE idRoom  ="+idRoom+";";
        Room Room = null;
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }

    }
}
