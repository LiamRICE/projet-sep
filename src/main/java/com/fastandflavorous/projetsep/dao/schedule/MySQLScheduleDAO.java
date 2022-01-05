package com.fastandflavorous.projetsep.dao.schedule;

import com.fastandflavorous.projetsep.model.schedule.Slot;
import com.fastandflavorous.projetsep.model.users.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLScheduleDAO extends AbstractScheduleDAO{

    private Connection connection ;

    public MySQLScheduleDAO(Connection connection){
        this.connection = connection;
    }

    public List<Slot> getSlots() {
        String query = "SELECT * FROM Slot;";
        List<Slot> slotList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Slot slot = new Slot(rs.getInt("idSlot"), rs.getString("startingTime"), rs.getString("endingTime"),rs.getDate("date"));
                slotList.add(slot);
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return slotList;
    }

    public List<Employee> getEmployesFromSlot(Slot slot){
        String query = "SELECT * FROM Slot_Employee WHERE idSlot="+slot.getIdSlot()+";";
        List<Employee> listOfAssignedEmployee = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employee employee = new Employee(rs.getString("name"),rs.getString("email"), rs.getString("password"),rs.getFloat("salary"),rs.getBoolean("isDirector"));
                listOfAssignedEmployee.add(employee);
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return listOfAssignedEmployee;
    }

    public Slot addSlot(String startingTime, String endingTime,Date date){
        Statement stmt = null;
        ResultSet rs = null;

        int autoIncKeyFromApi = -1;

        try {
            stmt = connection.createStatement();
            String update = "INSERT INTO Slot VALUES('"+startingTime+"',"+endingTime+",'"+new java.sql.Date(date.getTime()) +"';)";
            stmt.executeUpdate(
                    update,
                    Statement.RETURN_GENERATED_KEYS);



            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            } else {

                // throw an exception from here
            }

            System.out.println("Key returned from getGeneratedKeys():"
                    + autoIncKeyFromApi);
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return new Slot(autoIncKeyFromApi,startingTime,endingTime,date);
    }

    public void addEmployeeToSlot(Slot slot,Employee employee){
        Statement stmt = null;
        ResultSet rs = null;

        int autoIncKeyFromApi = -1;

        try {
            stmt = connection.createStatement();
            String update = "INSERT INTO Slot_Employee VALUES("+slot.getIdSlot()+","+employee.getIdEmployee()+";)";
            stmt.executeUpdate(
                    update,
                    Statement.RETURN_GENERATED_KEYS);



            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            } else {

                // throw an exception from here
            }

            System.out.println("Key returned from getGeneratedKeys():"
                    + autoIncKeyFromApi);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void deleteSlot(Slot slot){
        Statement stmt = null;
        ResultSet rs = null;

        int autoIncKeyFromApi = -1;

        try {
            stmt = connection.createStatement();
            String update = "DELETE FROM Slot WHERE idSlot="+slot.getIdSlot()+";";
            stmt.executeUpdate(
                    update,
                    Statement.RETURN_GENERATED_KEYS);



            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            } else {

                // throw an exception from here
            }

            System.out.println("Key returned from getGeneratedKeys():"
                    + autoIncKeyFromApi);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void deleteEmployeeFromSlot(Slot slot,Employee employee){
        Statement stmt = null;
        ResultSet rs = null;

        int autoIncKeyFromApi = -1;

        try {
            stmt = connection.createStatement();
            String update = "DELETE FROM Slot_Employee WHERE idSlot="+slot.getIdSlot()+" AND idEmployee="+employee.getIdEmployee()+";";
            stmt.executeUpdate(
                    update,
                    Statement.RETURN_GENERATED_KEYS);



            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            } else {

                // throw an exception from here
            }

            System.out.println("Key returned from getGeneratedKeys():"
                    + autoIncKeyFromApi);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

}
