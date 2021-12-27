package com.fastandflavorous.projetsep.facade.login;

import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.users.*;

/**
 * 
 */
public abstract class  AbstractUserFacade {

    private AbstractFactory factory;

    /**
     * Default constructor
     */
    public AbstractUserFacade() {
        this.factory = AbstractFactory.getFactory();
    }

    /**
     * Ask the business logic to check the client credential
     * @param token the token that allows the client to log in to the application
     * @return It returns the client if the credential is right otherwise it returns the null
     */
    public abstract boolean checkClientLogin(String token);

    public abstract String getUserName();

    /**
     * Ask the business logic to check the employee credentials
     * @param email the email that allows the employee to log in to the application
     * @param password the password that allows the employee to log in to the application
     * @return It returns the employee if the credentials were right otherwise it returns the null
     */
    public abstract boolean checkEmployeeLogin(String email, String password);



}