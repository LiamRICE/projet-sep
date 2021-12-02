package com.fastandflavorous.projetsep.dao.users;

import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.Employee;
import java.sql.*;

/**
 * 
 */
public abstract class UserDAO {

    /**
     * Default constructor
     */
    public UserDAO() {
    }

    /**
     * @param String 
     * @return
     */
    public abstract Employee getEmployee(String email);

    /**
     * @param String 
     * @return
     */
    public abstract Client getClient(String token);

}