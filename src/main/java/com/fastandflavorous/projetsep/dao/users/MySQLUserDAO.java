package com.fastandflavorous.projetsep.dao.users;

import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class MySQLUserDAO extends AbstractUserDAO {

    private Connection connection ;
/*
    private static Statement statement ;

    private static String url = "jdbc:mysql://mysql-igstudent74.alwaysdata.net:3306/igstudent74_fastandflavorous";

    private static String user = "250831";

    private static String password = "fastandflavorous";
*/
    /**
     * This method is used to establish the connection with the database
     * @return it returns a Connection static object that allows us to communicate with the databse
     */
/*
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();

            System.out.println("Connection Established");

        }catch(Exception e){
            System.err.println(e);
        }
        return connection;
    }
*/
    /**
     * Default constructor
     */
    public MySQLUserDAO(Connection connection){
        this.connection = connection;
    }

    /**
     * This method is used to retrieve an Employee from the database according to their email
     * @param email The email that allows the employee to log in to the application
     * @return It returns the employee if they are found in the database otherwise it returns the null
     */
    public Employee getEmployee(String email) {
        String query = "SELECT * FROM Employee WHERE email ='"+email+"';";
        Employee employee = null;
        boolean isDirector = false;
        boolean isHired = false;
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                isDirector = rs.getBoolean("isDirector");
                isHired = rs.getBoolean("isHired");
                employee = new Employee(rs.getString("name"), rs.getString("email"), rs.getString("password"),rs.getFloat("salary"), isDirector, isHired);
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return employee;
    }

    /**
     * This method is used to retrieve a Client from the database according to their token
     * @param token The token that allows the client to log in to the application
     * @return It returns the client if they are found in the database otherwise it returns the null
     */
    public Client getClient(String token) {
        String query = "SELECT * FROM Client WHERE token ='"+token+"';";
        Client client = null;
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                client = new Client(rs.getString("name"), rs.getString("token"), rs.getInt("loyaltyPoints"));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return client;
    }

    public List<Employee> getEmployees(){
        String query = "SELECT * FROM Employee;";
        Employee employee = null;
        List<Employee> employeeList = new ArrayList<>();
        boolean isDirector = false;
        boolean isHired = false;
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                isDirector = rs.getBoolean("isDirector");
                isHired = rs.getBoolean("isHired");
                employee = new Employee(rs.getString("name"), rs.getString("email"), rs.getString("password"),rs.getFloat("salary"), isDirector, isHired);
                employeeList.add(employee);
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return employeeList;
    }

    private int freeEmployeeIndex(){
        int index = 0;
        String query = "SELECT idEmployee FROM Employee;";
        List<Integer> intList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                intList.add(rs.getInt("idEmployee"));
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

    public void addEmployee(Employee employee){
        int id = freeEmployeeIndex();
        String query = "INSERT INTO Employee VALUES (" + id + ",'" + employee.getEmail() + "','" + employee.getPassword() + "'," + employee.getSalary() + ",'" + employee.getName() + "', "+employee.isDirector()+","+employee.isHired()+");";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void editEmployee(Employee e){
        String query = "UPDATE Employee SET email='" + e.getEmail() + "', password='" + e.getPassword() + "', salary=" + e.getSalary() + ", isDirector="+e.isDirector()+", isHired="+e.isHired()+" WHERE name='"+e.getName()+"';";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

}