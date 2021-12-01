package com.fastandflavorous.projetsep.facade.login;

import com.fastandflavorous.projetsep.factory.users.AbstractUserFactory;
import com.fastandflavorous.projetsep.factory.users.UserFactory;
import com.fastandflavorous.projetsep.model.users.*;

/**
 * 
 */
public abstract class AbstractUserFacade {

    private AbstractUserFactory factory;

    /**
     * Default constructor
     */
    public AbstractUserFacade() {
        this.factory = new UserFactory();
    }

    /**
     * @param token
     * @return
     */
    public Client checkClientLogin(String token) {
        return factory.checkClientLogin(token);
    }

    /**
     * @param email
     * @param password
     * @return
     */
    public Employee checkEmployeeLogin(String email, String password) {
        return factory.checkEmployeeLogin(email, password);
    }

}