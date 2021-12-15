package com.fastandflavorous.projetsep.facade.login;

import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.users.*;

/**
 * 
 */
public abstract class AbstractUserFacade {

    private AbstractFactory factory;
    private User user;

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
    public boolean checkClientLogin(String token) {
        Client client = factory.getUserDAO().getClient(token);
        this.user = client;
        if(this.user!=null){
            factory.getClientManager().addClient((Client) this.user);
        }
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
        Employee e = factory.getUserDAO().getEmployee(email);
        this.user = e;
        if(e!=null) {
            String hashedEnteredPassword = factory.getHashedPassword(password);
            if (hashedEnteredPassword.equals(e.getPassword())) {
                factory.getEmployeeManager().addEmployee(e);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

}