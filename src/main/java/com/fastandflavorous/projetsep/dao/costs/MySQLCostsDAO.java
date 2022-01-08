package com.fastandflavorous.projetsep.dao.costs;

import com.fastandflavorous.projetsep.model.costs.Cost;
import com.fastandflavorous.projetsep.model.users.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLCostsDAO extends AbstractCostsDAO {

    private Connection connection ;

    /**
     * Default constructor
     */
    public MySQLCostsDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Cost> getAllCosts(){
        String query = "SELECT * FROM Cost;";
        List<Cost> costs = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                costs.add(new Cost(rs.getInt("idCost"),rs.getString("label"),rs.getFloat("amount"),rs.getDate("lastModificationDate")));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return costs;
    }

    public Cost getCostById(int idCost){
        String query = "SELECT * FROM Cost WHERE idCost='"+idCost+"';";
        Cost cost = null;
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cost = new Cost(rs.getInt("idCost"),rs.getString("label"),rs.getFloat("amount"),rs.getDate("lastModificationDate"));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return cost;
    }

    public Cost addCost(String label){
        Statement stmt = null;
        ResultSet rs = null;
        int autoIncKeyFromApi = -1;
        Date creationDate = new Date();

        try {
            stmt = connection.createStatement();
            String update = "INSERT INTO Cost VALUES(NULL,'"+label+"',"+0+",'"+new java.sql.Date(creationDate.getTime()) +"');";
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
        return new Cost(autoIncKeyFromApi,label,0,creationDate);
    }

    public void removeCostById(int idCost){
        String update = "DELETE FROM Cost WHERE idCost  ="+idCost+";";
        Cost cost = null;
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }

    }

    public void setCostAmount(int idCost, float amount, Date modificationDate){
        String update = "UPDATE Cost SET amount = "+amount+", lastModificationDate='"+new java.sql.Date(modificationDate.getTime()) +"' WHERE idCost  ="+idCost+";";
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }
    }

    public void setCostLabel(int idCost, String label,Date modificationDate){
        String update = "UPDATE Cost SET label = '"+label+"', lastModificationDate='"+new java.sql.Date(modificationDate.getTime()) +"' WHERE idCost  ="+idCost+";";
        Cost cost = null;
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }
    }
}
