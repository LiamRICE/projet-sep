package com.fastandflavorous.projetsep.facade.login;

import com.fastandflavorous.projetsep.model.users.*;

/**
 * 
 */
public abstract class AbstractUserFacade {

    /**
     * Default constructor
     */
    public AbstractUserFacade() {
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

}