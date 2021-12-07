package com.fastandflavorous.projetsep.facade.login;

import com.fastandflavorous.projetsep.factory.users.AbstractUserFactory;
import com.fastandflavorous.projetsep.factory.users.UserFactory;
import com.fastandflavorous.projetsep.model.users.*;

/**
 * 
 */
public abstract class AbstractUserFacade {

    private AbstractUserFactory factory;
    private User user;

    /**
     * Default constructor
     */
    public AbstractUserFacade() {
        this.factory = AbstractUserFactory.getFactory();
    }

    /**
     * Ask the business logic to check the client credential
     * @param token the token that allows the client to log in to the application
     * @return It returns the client if the credential is right otherwise it returns the null
     */
    public boolean checkClientLogin(String token) {
        this.user = factory.checkClientLogin(token);
        if(this.user == null){
            return false;
        }else{
            return true;
        }
    }

    public String getUserName(){
        if(user != null) {
            return this.user.getName();
        }else{
            return "UNKNOWN";
        }
    }

    /**
     * Ask the business logic to check the employee credentials
     * @param email the email that allows the employee to log in to the application
     * @param password the password that allows the employee to log in to the application
     * @return It returns the employee if the credentials were right otherwise it returns the null
     */
    public boolean checkEmployeeLogin(String email, String password) {
        this.user = factory.checkEmployeeLogin(email, password);
        if(this.user == null){
            return false;
        }else{
            return true;
        }
    }

}