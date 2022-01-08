package com.fastandflavorous.projetsep.facade.login;

import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.users.*;

import java.util.List;

/**
 * 
 */
public abstract class  AbstractUserFacade {

    private AbstractFactory factory;
    private static UserFacade facade = null;
    private static Object sync = new Object();

    /**
     * Default constructor
     */
    public AbstractUserFacade() {
        this.factory = AbstractFactory.getFactory();
    }

    public static AbstractUserFacade getFacade(){
        if(facade != null){
            return facade;
        }
        synchronized (sync) {
            if (facade == null) {
                facade = new UserFacade();
                return facade;
            }else{
                return facade;
            }
        }
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


    public abstract boolean isCurrentUserDirector();

    public abstract void addEmployee(String name, String email, String password, float salary, boolean id, boolean is);

    public abstract List<Employee> getEmployees();

    public abstract void editEmployee(Employee e);
}