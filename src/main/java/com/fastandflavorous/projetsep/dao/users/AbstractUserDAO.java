package com.fastandflavorous.projetsep.dao.users;

import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.Employee;

import java.util.List;

/**
 *
 */
public abstract class AbstractUserDAO {

    private static AbstractUserDAO dao;
    private static Object sync = new Object();

    /**
     * Default constructor
     */
    protected AbstractUserDAO() {
    }

    /**
     * This method is used to retrieve an Employee from the database according to their email
     * @param email The email that allows the employee to log in to the application
     * @return It returns the employee if they are found in the database otherwise it returns the null
     */
    public abstract Employee getEmployee(String email);

    /**
     * This method is used to retrieve a Client from the database according to their token
     * @param token The token that allows the client to log in to the application
     * @return It returns the client if they are found in the database otherwise it returns the null
     */
    public abstract Client getClient(String token);

    public abstract List<Employee> getEmployees();

    public abstract void addEmployee(Employee e);

    public abstract void editEmployee(Employee e);

}