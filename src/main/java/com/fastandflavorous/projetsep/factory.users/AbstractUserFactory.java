package com.fastandflavorous.projetsep.factory.users;

import com.fastandflavorous.projetsep.dao.users.UserDAO;
import com.fastandflavorous.projetsep.dao.users.UserDAOSQL;
import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.ClientManager;
import com.fastandflavorous.projetsep.model.users.Employee;
import com.fastandflavorous.projetsep.model.users.EmployeeManager;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * 
 */
public class AbstractUserFactory {

    private UserDAO dao;
    private EmployeeManager employeeManager;
    private ClientManager clientManager;


    private static final String SALT = "fastAndFlavorous";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

    /**
     * Default constructor
     */
    public AbstractUserFactory() {
        this.dao = new UserDAOSQL();
        this.employeeManager = EmployeeManager.getEmployeeManager();
        this.clientManager = ClientManager.getClientManager();
    }

    /**
     * This method checks if the token received from the ui is corresponding to a token found by the DAO
     * @param token the token that allows the client to log in to the application
     * @return It returns the client if they are found by the DAO otherwise it returns the null
     */
    public Client checkClientLogin(String token) {
        Client client = dao.getClient(token);
        if(client!=null){
            clientManager.addClient(client);
        }
        return client;
    }

    /**
     * This method checks if the token received from the ui is corresponding to a token found by the DAO
     * @param email the email that allows the client to log in to the application
     * @param password the password that allows the client to log in to the application
     * @return It returns the employee if they are found by the DAO otherwise it returns the null
     */
    public Employee checkEmployeeLogin(String email, String password) {
        Employee e = dao.getEmployee(email);
        if(e!=null) {
            String hashedEnteredPassword = getHashedPassword(password);
            if (hashedEnteredPassword.equals(e.getPassword())) {
                employeeManager.addEmployee(e);
                return e;
            } else {
                return null;
            }
        }else{
            return e;
        }
    }


    /**
     * This methods hashes the password passed in parameter depending on the static constants SALT and ALGORITHM
     * @param password password to hash
     * @return The hashed password
     */
    private String getHashedPassword(String password){
        byte[] salt = SALT.getBytes();
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        String base64encoded ="";
        try{
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = factory.generateSecret(spec).getEncoded();
            base64encoded = Base64.getEncoder().encodeToString(hash);
        }catch (NoSuchAlgorithmException| InvalidKeySpecException ex){
            System.err.println(ex);
        }
        return base64encoded;
    }

    /**
     * @param employee
     * @return
     */
    public void addEmployeeToManager(Employee employee) {
        // TODO implement here
    }

    /**
     * @param client
     * @return
     */
    public void addClientToManager(Client client) {
        // TODO implement here
    }

}