package com.fastandflavorous.projetsep.dao.users;

import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.Employee;

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
    public Employee getEmployee(String email) {
        // TODO implement here
        return null;
    }

    /**
     * @param String 
     * @return
     */
    public Client getClient(String token) {
        // TODO implement here
        return null;
    }

}