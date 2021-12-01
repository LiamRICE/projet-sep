package com.fastandflavorous.projetsep.factory.users;

import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.Employee;

/**
 * 
 */
public class AbstractUserFactory {

    /**
     * Default constructor
     */
    public AbstractUserFactory() {
    }

    /**
     * @param String 
     * @return
     */
    public Client checkClientLogin(String token) {
        // TODO implement here
        return null;
    }

    /**
     * @param String 
     * @param String 
     * @return
     */
    public Employee checkEmployeeLogin(String email, String password) {
        // TODO implement here
        return null;
    }

    /**
     * @param Employee 
     * @return
     */
    public void addEmployeeToManager(Employee employee) {
        // TODO implement here
    }

    /**
     * @param Client 
     * @return
     */
    public void addClientToManager(Client client) {
        // TODO implement here
    }

}