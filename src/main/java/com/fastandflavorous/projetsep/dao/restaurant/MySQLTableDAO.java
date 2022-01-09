package com.fastandflavorous.projetsep.dao.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Room;
import com.fastandflavorous.projetsep.model.restaurant.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLTableDAO extends AbstractTableDAO{

    private Connection connection;

    public MySQLTableDAO(Connection connection) {
        this.connection = connection;
    }

    public void setNumberOfSeats(int idTable, int newNumberOfSeats) {
        String update = "UPDATE Table_ SET numberOfSeats = "+newNumberOfSeats+" WHERE idTable="+ idTable+";";
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }

    }

    public List<Table> getAllTables(){
        String query = "SELECT * FROM Table_;";
        List<Table> Tables = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Tables.add(new Table(rs.getInt("idTable"),rs.getInt("idRoom"),rs.getInt("numberOfSeats")));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return Tables;
    }

    public Table getTableById(int idTable){
        String query = "SELECT * FROM Table_ WHERE idTable='"+idTable+"';";
        Table Table = null;
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Table = new Table(rs.getInt("idTable"),rs.getInt("idRoom"),rs.getInt("numberOfSeats"));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return Table;
    }

    public Table addTable(int idRoom, int numberOfSeats){
        Statement stmt = null;
        ResultSet rs = null;
        int autoIncKeyFromApi = -1;
        java.util.Date creationDate = new java.util.Date();

        try {
            stmt = connection.createStatement();
            String update = "INSERT INTO Table_ VALUES(NULL,"+idRoom+","+numberOfSeats+");";
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
        return new Table(autoIncKeyFromApi,idRoom,numberOfSeats);
    }


    public void removeTableById(int idTable){
        String update = "DELETE FROM Table_ WHERE idTable  ="+idTable+";";
        Table Table = null;
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }

    }
}
