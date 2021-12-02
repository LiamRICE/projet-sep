package com.fastandflavorous.projetsep.dao.users;

import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.Employee;
import java.sql.*;



/**
 * 
 */
public class UserDAOSQL extends UserDAO {

    private static Connection connection ;

    private static Statement statement ;

    private static String url = "jdbc:mysql://mysql-igstudent74.alwaysdata.net:3306/igstudent74_fastandflavorous";

    private static String user = "250831";

    private static String password = "fastandflavorous";

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

    /**
     * Default constructor
     */
    public UserDAOSQL(){
        this.connection = getConnection();
    }

    /**
     * @param String
     * @return
     */
    public Employee getEmployee(String email) {
        String query = "SELECT * FROM Employee WHERE email ='"+email+"';";
        Employee employee = null;
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                employee = new Employee(rs.getString("name"), rs.getString("email"), rs.getString("password"),rs.getFloat("salary"));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return employee;
    }

    /**
     * @param String
     * @return
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

}